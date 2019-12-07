package com.grabathon.booster.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabathon.booster.model.Message;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

  private static final String MESSAGE = "Hello, World!";

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
  public Message hello() {
    Message message = new Message();
    message.setMessage(MESSAGE);
    return message;
  }

}