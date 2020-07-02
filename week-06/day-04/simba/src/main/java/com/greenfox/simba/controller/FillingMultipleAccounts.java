package com.greenfox.simba.controller;

import com.greenfox.simba.model.BankAccount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FillingMultipleAccounts {

  List<BankAccount> accounts = new ArrayList<>(Arrays.asList(
      new BankAccount("Simba", 1234f, "lion"),
      new BankAccount("Timon", 34532f, "meerkat"),
      new BankAccount("Pumbaa", 853f, "warthog"),
      new BankAccount("Rafiki", 743f, "baboon")
  ));

  @GetMapping("/accounts")
  public String showAccounts(Model model) {
    model.addAttribute("accounts",accounts);
    return "accounts";
  }

  @PostMapping("/raise")
  public String raiseBalance(Integer index) {
    if(index > 0 && index <= accounts.size())
      accounts.get(index - 1).raiseBalance();
    return "redirect:/accounts";
  }
}
