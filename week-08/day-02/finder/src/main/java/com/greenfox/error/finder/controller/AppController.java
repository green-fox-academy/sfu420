package com.greenfox.error.finder.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.greenfox.error.finder.service.UserService;
import com.greenfox.error.finder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by aze on 25/10/17.
 */
@Controller
@RequestMapping("/app")
public class AppController {

  private UserService service;

  @Autowired
  public AppController(UserService service) {
    this.service = service;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("new_user", new User());
    model.addAttribute("yolo", service.getAll());
    return "main";
  }

  @PostMapping("/")
  public String create(@ModelAttribute User user) {
    service.save(user);
    return "redirect:/app/";
  }
}