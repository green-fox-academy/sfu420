package com.greenfox.reddit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/r")
public class MainController {

  @GetMapping("/greenfox")
  public String listThreads() {
    return "index";
  }

}
