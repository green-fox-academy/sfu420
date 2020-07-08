package com.greenfox.di.utilities.controller;

import com.greenfox.di.utilities.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Endpoints {

  private UtilityService utilities;

  @Autowired
  Endpoints(UtilityService utilities) {
    this.utilities = utilities;
  }

  @GetMapping("/useful")
  public String mainPage() {
    return "index";
  }

  @GetMapping("/useful/colored")
  public String coloredBG(Model model) {
    model.addAttribute("color", utilities.randomColor());
    return "colored";
  }

}
