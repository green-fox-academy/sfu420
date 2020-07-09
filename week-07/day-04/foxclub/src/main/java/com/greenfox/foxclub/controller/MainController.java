package com.greenfox.foxclub.controller;

import com.greenfox.foxclub.model.Fox;
import com.greenfox.foxclub.model.Trick;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  List<Fox> foxes = new ArrayList<>(Arrays.asList(
      new Fox("Johny", Arrays.asList(Trick.WRITE_HTML), "Burger", "Hell"),
      new Fox("Sanyi", Arrays.asList(Trick.WRITE_HTML, Trick.STYLE_WITH_CSS), "Pizza", "Beer"),
      new Fox("Mr. Green", Arrays.asList(Trick.WRITE_HTML, Trick.CREATE_FORMS), "Pasta", "Wine")
  ));

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
      foxes.add(new Fox(name, Arrays.asList(), "Snack", "Cola"));
    }
    return "redirect:/?name=" + name;
  }

  public Optional<Fox> findFox(String name) {
    return foxes.stream().filter(fox -> fox.getName().equals(name)).findFirst();
  }
}
