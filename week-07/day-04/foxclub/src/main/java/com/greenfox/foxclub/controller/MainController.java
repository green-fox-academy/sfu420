package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.model.Trick;
import com.greenfox.foxclub.service.LoggingService;
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

  private LoggingService logging;

  private List<Fox> foxes = new ArrayList<>(Arrays.asList(
      new Fox("Johny", new ArrayList<>(Arrays.asList(Trick.WRITE_HTML)), "Burger", "Hell"),
      new Fox("Sanyi", new ArrayList<>(Arrays.asList(Trick.WRITE_HTML, Trick.STYLE_WITH_CSS)), "Pizza", "Beer"),
      new Fox("Mr. Green", new ArrayList<>(Arrays.asList(Trick.WRITE_HTML, Trick.CREATE_FORMS)), "Pasta", "Wine")
  ));
  private List<String> foods =
      new ArrayList<>(Arrays.asList("Burger", "Pizza", "Pasta", "Bread", "Cheese", "Snack"));
  private List<String> drinks =
      new ArrayList<>(Arrays.asList("Cola", "Hell", "Water", "Beer", "Coffee"));

  public MainController(LoggingService logging) {
    this.logging = logging;
  }

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
      logging.addNewItem("A new fox has been added with name: " + name);
    }
    return "redirect:/?name=" + name;
  }

  // Nutrition Store //
  @GetMapping("/nutritionStore")
  public String getNutrition(@RequestParam String name, Model model) {
    if (findFox(name).isPresent()) {
      Fox currentFox = findFox(name).get();

      model.addAttribute("name", currentFox.getName());
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
      String oldFood = currentFox.getFood();
      String oldDrink = currentFox.getDrink();

      if (!oldFood.equals(newFood)) {
        currentFox.setFood(newFood);
        logging.addNewItem("Food has been changed from " + oldFood + " to " + newFood);
      }

      if (!oldDrink.equals(newDrink)) {
        currentFox.setDrink(newDrink);
        logging.addNewItem("Drink has been changed from " + oldDrink + " to " + newDrink);
      }

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

      currentFox.addTrick(trick);
      logging.addNewItem("Learned to: " + trick);

      return "redirect:/?name=" + name;
    }
    return "redirect:/login";
  }

  // Action History //
  @GetMapping("/actionHistory")
  public String listHistory(@RequestParam String name, Model model) {
    if (findFox(name).isPresent()) {
      model.addAttribute("name", name);
      model.addAttribute("history", logging.getHistory());
      return "history";
    }
    return "redirect:/login";
  }

  // Helper methods //
  public Optional<Fox> findFox(String name) {
    return foxes.stream().filter(fox -> fox.getName().equals(name)).findFirst();
  }
}