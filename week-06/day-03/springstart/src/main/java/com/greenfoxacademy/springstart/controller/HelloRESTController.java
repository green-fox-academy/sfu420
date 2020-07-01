package com.greenfoxacademy.springstart.controller;

import com.greenfoxacademy.springstart.model.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

  protected AtomicLong greetCounter = new AtomicLong();

  @RequestMapping(value = "/greeting")
  public Greeting greeting(@RequestParam String name) {
    Greeting greetingObj = new Greeting(greetCounter.incrementAndGet(), "Hello, " + name + "!");
    return greetingObj;
  }
}
