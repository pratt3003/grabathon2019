package com.grabathon.booster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grabathon.booster.model.Message;
import com.grabathon.booster.repository.HelloWorldRepository;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

  private static final String MESSAGE = "Hello, World!";

  @Autowired
  private HelloWorldRepository helloWorldRepository;

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
  public List<Message> hello() {
    return helloWorldRepository.findAll();
  }

}