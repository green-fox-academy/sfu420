package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.model.Trick;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  List<Fox> foxes = new ArrayList<>(Arrays.asList(
      new Fox("Johny", new ArrayList<>(Arrays.asList(Trick.WRITE_HTML)), "Burger", "Hell"),
      new Fox("Sanyi", new ArrayList<>(Arrays.asList(Trick.WRITE_HTML, Trick.STYLE_WITH_CSS)), "Pizza", "Beer"),
      new Fox("Mr. Green", new ArrayList<>(Arrays.asList(Trick.WRITE_HTML, Trick.CREATE_FORMS)), "Pasta", "Wine")
  ));
  List<String> foods = new ArrayList<>(Arrays.asList("Burger", "Pizza", "Pasta", "Bread", "Cheese"));
  List<String> drinks = new ArrayList<>(Arrays.asList("Cola", "Hell", "Water", "Beer", "Coffee"));

  // Information Page//
  @GetMapping("/")
  public String information(@RequestParam Optional<String> name, Model model) {
    if (name.isPresent() && !name.get().isEmpty()) {
      if (findFox(name.get()).isPresent()) {
        Fox currentFox = findFox(name.get()).get();
        model.addAttribute("name", currentFox.getName());
        model.addAttribute("description", currentFox.toString());
        model.addAttribute("tricks", currentFox.getTricks());
      } else {
        return "redirect:/login?error=notfound";
      }
    } else {
      return "redirect:/login";
    }
    return "index";
  }

  // Login //
  @GetMapping("/login")
  public String loginPage(@RequestParam Optional<String> error, Model model) {
    if (error.isPresent() && error.get().equals("notfound")) {
      model.addAttribute("error",
          "You have provided a name that has not been used before, add it as a new one!");
    }
    return "login";
  }

  @PostMapping("/login")
  public String getName(@RequestParam String name) {
    if (!findFox(name).isPresent()) {
      foxes.add(new Fox(name, new ArrayList<>(), "Snack", "Cola"));
    }
    return "redirect:/?name=" + name;
  }

  public Optional<Fox> findFox(String name) {
    return foxes.stream().filter(fox -> fox.getName().equals(name)).findFirst();
  }

  // Nutrition Store //
  @GetMapping("/nutritionStore")
  public String getNutrition(@RequestParam String name, Model model) {
    if (findFox(name).isPresent()) {
      Fox currentFox = findFox(name).get();
      model.addAttribute("name", currentFox.getName());   // Why need this????
      model.addAttribute("foods", foods);
      model.addAttribute("currentFood", currentFox.getFood());
      model.addAttribute("drinks", drinks);
      model.addAttribute("currentDrink", currentFox.getDrink());
      return "nutrition";
    }
    return "redirect:/login";
  }

  @PostMapping("/nutritionStore")
  public String changeNutrition(@RequestParam String name,
                                @RequestParam String newFood,
                                @RequestParam String newDrink) {
    if (findFox(name).isPresent()) {
      Fox currentFox = findFox(name).get();
      currentFox.setFood(newFood);
      currentFox.setDrink(newDrink);
      return "redirect:/?name=" + name;
    }
    return "redirect:/login";
  }

  // Trick Center //
  @GetMapping("/trickCenter")
  public String getTricks(@RequestParam String name, Model model) {
    if (findFox(name).isPresent()) {
      Fox currentFox = findFox(name).get();

      List<Trick> learnableTricks = Arrays.stream(Trick.values())
          .filter(trick -> !(currentFox.getTricks().contains(trick)))
          .collect(Collectors.toList());

      model.addAttribute("name", currentFox.getName());
      model.addAttribute("tricks", learnableTricks);
      return "tricks";
    }
    return "redirect:/login";
  }

  @PostMapping("/trickCenter")
  public String learnTrick(@RequestParam String name, @RequestParam Trick trick) {
    if (findFox(name).isPresent()) {
      Fox currentFox = findFox(name).get();
      System.out.println(trick);
      currentFox.addTrick(trick);
      return "redirect:/?name=" + name;
    }
    return "redirect:/login";
  }
}