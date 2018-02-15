package com.joeo;

import com.joeo.config.ApplicationSettings;
import com.joeo.config.RestConfiguration;

import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {
  private static Logger log = LoggerFactory.getLogger(Main.class);
  private static final int PORT = 9290;
  private static final String CONTEXT_PATH = "/";

  public static void main(String[] args) throws Exception {
    log.info("Hello logging!");

    new Main().startJetty(PORT);
  }

  private void startJetty(int port) throws Exception {
    Server server = new Server(port);

    server.setHandler(getServletContextHandler());

    addRuntimeShutdownHook(server);

    server.start();
    server.join();
  }

  private static ServletContextHandler getServletContextHandler() throws IOException {
    ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

    //contextHandler.setErrorHandler(null); //TODO
    //contextHandler.setContextPath(CONTEXT_PATH); //TODO Something than "/" ?

    // Spring
    AnnotationConfigWebApplicationContext webAppContext = new AnnotationConfigWebApplicationContext();
    webAppContext.register(ApplicationSettings.class);
    webAppContext.register(RestConfiguration.class);

    DispatcherServlet dispatcherServlet = new DispatcherServlet(webAppContext);
    ServletHolder springServletHolder = new ServletHolder("rest-dispatcher", dispatcherServlet);
    contextHandler.addServlet(springServletHolder, CONTEXT_PATH);

    return contextHandler;
  }

  private static void addRuntimeShutdownHook(final Server server) {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        if (server.isStarted()) {
          server.setStopAtShutdown(true);
          try {
            server.stop();
          } catch (Exception e) {
            System.out.println("Error while stopping jetty server: " + e.getMessage());
          }
        }
    }));
  }
}
