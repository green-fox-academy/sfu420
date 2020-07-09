package com.greenfox.foxclub.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


  @GetMapping("/")
  public String information(@RequestParam Optional<String> name, Model model) {
    if (name.isPresent() && !name.get().isEmpty()) {
      model.addAttribute("name", name);
    } else {
      return "redirect:/login";
//      model.addAttribute("name", "Anonymous");
    }
    return "index";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String getName(@RequestParam String name) {
    return "redirect:/?name=" + name;
  }
}
