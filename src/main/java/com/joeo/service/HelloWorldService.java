package com.joeo.service;

import com.joeo.dao.HelloWorldMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
  private static Logger log = LoggerFactory.getLogger(HelloWorldService.class);

  @Value("${helloworld.message}")
  private String message;

  public HelloWorldService() {
    log.info("HelloWorldService created");
  }

  public HelloWorldMessage sayHello() {
    return new HelloWorldMessage(this.message);
  }
}
