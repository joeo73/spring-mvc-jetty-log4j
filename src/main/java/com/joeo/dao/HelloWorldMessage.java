package com.joeo.dao;

public class HelloWorldMessage {
  String message;

  public HelloWorldMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public HelloWorldMessage setMessage(String message) {
    this.message = message;
    return this;
  }
}
