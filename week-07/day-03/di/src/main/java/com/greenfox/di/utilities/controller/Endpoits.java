package com.greenfox.di.utilities.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Endpoits {

  @GetMapping("/useful")
  public String mainPage() {
    return "index";
  }



}
