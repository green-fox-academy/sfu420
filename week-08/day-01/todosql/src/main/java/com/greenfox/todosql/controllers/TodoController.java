package com.greenfox.todosql.controllers;

import com.greenfox.todosql.models.Todo;
import com.greenfox.todosql.repositories.TodoRepository;
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

  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping({"/", "/list"})
  public String listTodos(@RequestParam(required = false) Optional<Boolean> isActive, Model model) {
    if(isActive.isPresent()) {
      model.addAttribute("todos", todoRepository.findTodoByDone(!isActive.get()));
    } else {
      model.addAttribute("todos", todoRepository.findAll());
    }
    return "todo";
  }

  @GetMapping("/add")
  public String addTodoForm() {
    return "add";
  }

  @PostMapping("/add")
  public String createNewTodo(@RequestParam String title) {
    todoRepository.save(new Todo(title));
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String deleteById(@PathVariable Long id) {
    todoRepository.deleteById(id);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable Long id, Model model) {
    if(todoRepository.findById(id).isPresent()) {
      model.addAttribute("todo", todoRepository.findById(id).get());
      return "edit";
    } else {
      return "redirect:/todo/list";
    }
  }

  @PostMapping("/{id}/edit")
  public String editTodo(@PathVariable Long id,
                         @RequestParam String title,
                         @RequestParam Optional<String> urgent,
                         @RequestParam Optional<String> done) {
    Todo res;
    if (todoRepository.findById(id).isPresent()) {
      res = todoRepository.findById(id).get();
      res.setTitle(title);
      res.setUrgent(urgent.isPresent());
      res.setDone(done.isPresent());
      todoRepository.save(res);
    }
    return "redirect:/todo/list";
  }
}
