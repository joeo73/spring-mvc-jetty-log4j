package com.joeo.controller;

import com.joeo.Main;
import com.joeo.dao.HelloWorldMessage;
import com.joeo.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
  private static Logger log = LoggerFactory.getLogger(Main.class);

  public Index() {
    log.info("Index created");
  }

  @Autowired
  HelloWorldService helloWorldService;

  @RequestMapping(value = "/helloWorld", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public HelloWorldMessage getMessage() {
    return helloWorldService.sayHello();
  }
}
