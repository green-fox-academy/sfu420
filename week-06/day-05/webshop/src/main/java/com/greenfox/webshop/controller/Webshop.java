package com.greenfox.webshop.controller;

import com.greenfox.webshop.model.Database;
import com.greenfox.webshop.model.ShopItem;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Webshop {

  protected Database products = new Database();
  protected String currency = "€";

  @GetMapping("/webshop")
  public String listAllItems(Model model) {
    model.addAttribute("products", products.getProducts());
    model.addAttribute("currency", currency);
    return "index";
  }

  @GetMapping("/only-available")
  public String onlyAvailable(Model model) {
    List<ShopItem> onlyAvailable = products.getProducts().stream()
        .filter(product -> product.getQtyOfStock() > 0)
        .collect(Collectors.toList());
    model.addAttribute("products", onlyAvailable);
    model.addAttribute("currency", currency);
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String cheapestFirst(Model model) {
    List<ShopItem> cheapestFirst = products.getProducts().stream()
        .sorted(Comparator.comparing(ShopItem::getPrice))
        .collect(Collectors.toList());
    model.addAttribute("products", cheapestFirst);
    model.addAttribute("currency", currency);
    return "index";
  }

  @GetMapping("/contains-nike")
  public String containsNike(Model model) {
    List<ShopItem> containsNike = products.getProducts().stream()
        .filter(product -> product.getName().toLowerCase().contains("nike") || product.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList());
    model.addAttribute("products", containsNike);
    model.addAttribute("currency", currency);
    return "index";
  }

}
