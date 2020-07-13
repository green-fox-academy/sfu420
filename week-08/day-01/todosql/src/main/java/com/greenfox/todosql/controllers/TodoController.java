package com.greenfox.todosql.controllers;

import com.greenfox.todosql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping({"/", "/list"})
  public String list(@RequestParam boolean isActive, Model model) {
    model.addAttribute("todos", todoRepository.findTodoByDone(!isActive));
    return "todo";
  }
}
