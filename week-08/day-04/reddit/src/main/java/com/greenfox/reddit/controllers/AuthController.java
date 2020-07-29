package com.greenfox.reddit.controllers;

import com.greenfox.reddit.models.User;
import com.greenfox.reddit.services.RedditUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

  private RedditUserDetailsService userService;

  @Autowired
  public AuthController(RedditUserDetailsService userService) {
    this.userService = userService;
  }

  @GetMapping("/")
  public String redirect() {
    return "redirect:/r/greenfox";
  }

  @GetMapping("/login")
  public ModelAndView login() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
    return modelAndView;
  }

  @GetMapping("/signup")
  public ModelAndView signup() {
    ModelAndView modelAndView = new ModelAndView();
    User user = new User();
    modelAndView.addObject("user", user);
    modelAndView.setViewName("signup");
    return modelAndView;
  }

  @PostMapping("/signup")
  public ModelAndView createNewUser(@ModelAttribute User user, BindingResult bindingResult) {
    ModelAndView modelAndView = new ModelAndView();
    User userExists = userService.findUserByEmail(user.getEmail());
    if (userExists != null) {
      bindingResult
          .rejectValue("email", "error.user",
              "There is already a user registered with the email provided");
    }
    userExists = userService.findUserByUsername(user.getUsername());
    if (userExists != null) {
      bindingResult
          .rejectValue("username", "error.user",
              "Username is not available");
    }
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("signup");
    } else {
      userService.saveUser(user);
      modelAndView.addObject("successMessage", "You have been registered successfully");
      modelAndView.addObject("user", new User());
      modelAndView.setViewName("index");

    }
    return modelAndView;
  }
}
