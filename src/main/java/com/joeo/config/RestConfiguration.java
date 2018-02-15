package com.joeo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.joeo")
@EnableWebMvc
public class RestConfiguration {
  private static Logger log = LoggerFactory.getLogger(RestConfiguration.class);

  public RestConfiguration() {
    log.info("RestConfiguration created");
  }

}
