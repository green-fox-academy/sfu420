package com.greenfox.todosql.controllers;

import com.greenfox.todosql.models.Todo;
import com.greenfox.todosql.services.TodoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  //  private TodoRepository todoRepository;
  private TodoService todoService;

//  @Autowired
//  public TodoController(TodoRepository todoRepository) {
//    this.todoRepository = todoRepository;
//  }

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping({"/", "/list"})
  public String listTodos(@RequestParam(required = false) Optional<Boolean> isActive, Model model) {
    if (isActive.isPresent()) {
      model.addAttribute("todos", todoService.getTodoByDone(!isActive.get()));
    } else {
      model.addAttribute("todos", todoService.getAll());
    }
    return "todo";
  }


  @GetMapping("/add")
  public String addForm() {
    return "add";
  }

  @PostMapping("/add")
  public String createTodo(@RequestParam String title) {
    todoService.createNew(title);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String deleteByID(@PathVariable Long id) {
    todoService.deleteByID(id);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable Long id, Model model) {
    if (todoService.getByID(id) != null) {
      model.addAttribute("todo", todoService.getByID(id));
      return "edit";
    } else {
      return "redirect:/todo/list";
    }
  }

  @PostMapping("/{id}/edit")
  public String updateTodo(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam Optional<String> urgent,
                           @RequestParam Optional<String> done) {
    todoService.updateRecord(id, title, urgent, done);
    return "redirect:/todo/list";
  }
}
