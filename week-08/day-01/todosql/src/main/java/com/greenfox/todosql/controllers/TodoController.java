package com.greenfox.todosql.controllers;

import com.greenfox.todosql.models.Assignee;
import com.greenfox.todosql.services.AssigneeService;
import com.greenfox.todosql.services.TodoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoService todoService;
  private AssigneeService assigneeService;

  @Autowired
  public TodoController(TodoService todoService, AssigneeService assigneeService) {
    this.todoService = todoService;
    this.assigneeService = assigneeService;
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
  public String addTodoForm() {
    return "add";
  }

  @PostMapping("/add")
  public String createTodo(@RequestParam String title) {
    todoService.createNew(title);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String deleteTodoByID(@PathVariable Long id) {
    todoService.deleteByID(id);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/edit")
  public String editTodoForm(@PathVariable Long id, Model model) {
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

  @PostMapping("/search")
  public String search(@RequestParam String searchBox, Model model) {
    model.addAttribute("todos", todoService.searchFor(searchBox));
    return "todo";
  }

  @GetMapping({"/assignee", "/assignee/{id}"})
  public String listAssignee(@PathVariable(required = false) Long id, Model model) {
    model.addAttribute("assignees", assigneeService.getAll());
//    if (id != null && assigneeService.getByID(id) != null) {
//      model.addAttribute("editAssignee", assigneeService.getByID(id));
//    }
    model.addAttribute("newAssignee", new Assignee());
    return "assignee";
  }

  @PostMapping("/assignee")
  public String createAssignee(@ModelAttribute Assignee newAssignee) {
    assigneeService.save(newAssignee);
    return "redirect:/todo/assignee";
  }

  @GetMapping("/deleteAssignee/{id}")
  public String deleteAssigneeByID(@PathVariable Long id) {
    assigneeService.deleteByID(id);
    return "redirect:/todo/assignee";
  }

  @GetMapping("/editAssignee/{id}")
  public String editAssigneeForm(@PathVariable Long id, Model model) {
    if (assigneeService.getByID(id) != null) {
      model.addAttribute("assignee", assigneeService.getByID(id));
      return "editAssignee";
    } else {
      return "redirect:/todo/assignee";
    }
  }

  @PostMapping("/editAssignee/{id}")
  public String editAssigneeByID(@PathVariable Long id,
                                 @RequestParam String name,
                                 @RequestParam String email) {
    Assignee res = assigneeService.getByID(id);
    res.setName(name);
    res.setEmail(email);
    assigneeService.save(res);
    return "redirect:/todo/assignee";
  }
}
