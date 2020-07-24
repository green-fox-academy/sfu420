package com.greenfox.urlalias.controllers;

import com.greenfox.urlalias.entities.models.Alias;
import com.greenfox.urlalias.services.AliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  private AliasService aliasService;

  @Autowired
  public MainController(AliasService aliasService) {
    this.aliasService = aliasService;
  }

  @GetMapping("/")
  public String mainPage(Model model) {
    Alias newAlias = new Alias();
    System.out.println(newAlias.getSecret());
    model.addAttribute("newAlias", newAlias);
    return "index";
  }

  @PostMapping("/save-link")
  public String saveNewAlias(@ModelAttribute Alias newAlias, Model model) {
    System.out.println(newAlias.getSecret());
    if (aliasService.findByUrlAlias(newAlias.getUrlAlias()).isPresent()) {
      model.addAttribute("message", "error");
      model.addAttribute("newAlias", newAlias);
    } else {
      aliasService.save(newAlias);
      model.addAttribute("message", "success");
      model.addAttribute("createdAlias", newAlias.getUrlAlias());
      model.addAttribute("createdSecret", newAlias.getSecret());
      model.addAttribute("newAlias", new Alias());
    }
    return "index";
  }
}
