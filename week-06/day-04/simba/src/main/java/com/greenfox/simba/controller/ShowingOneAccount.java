package com.greenfox.simba.controller;

import com.greenfox.simba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowingOneAccount {

  @GetMapping("/show")
  public String accountDetails(Model model) {
    BankAccount account = new BankAccount("Simba", 2000f, "lion");
    model.addAttribute("account", account);
    return "index";
  }
}
