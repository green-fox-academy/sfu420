package com.greenfox.di.utilities.controller;

import com.greenfox.di.utilities.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/useful/email")
  public String mailChecker(@RequestParam String email, Model model) {
    if (utilities.validateEmail(email)) {
      model.addAttribute("text", email + " is a valid email address");
      model.addAttribute("color", "green");
    } else {
      model.addAttribute("text", email + " is not a valid email address");
      model.addAttribute("color", "red");
    }
    return "mailchecker";
  }

  @GetMapping("/useful/encode")
  public String encode(@RequestParam(name="text") String text, @RequestParam(name="number") int number, Model model) {
    model.addAttribute("text", utilities.caesar(text, number));
    return "caesar";
  }

  @GetMapping("/useful/decode")
  public String decode(@RequestParam(name="text") String text, @RequestParam(name="number") int number, Model model) {
    model.addAttribute("text", utilities.caesar(text, -number));
    return "caesar";
  }
}
