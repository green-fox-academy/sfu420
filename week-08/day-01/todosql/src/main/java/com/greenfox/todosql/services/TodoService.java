package com.greenfox.todosql.services;

import com.greenfox.todosql.models.Todo;
import com.greenfox.todosql.repositories.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }


  public List<Todo> getAll() {
    return (List<Todo>) todoRepository.findAll();
  }

  public List<Todo> getTodoByDone(boolean isAcive) {
    return todoRepository.findTodoByDone(isAcive);
  }

  public Todo getByID(Long id) {
    if (todoRepository.findById(id).isPresent()) {
      return todoRepository.findById(id).get();
    }
    return null;
  }

  public Todo createNew(String title) {
    return todoRepository.save(new Todo(title));
  }

  public void deleteByID(Long id) {
    todoRepository.deleteById(id);
  }

  public Todo updateRecord(Long id, String title, Optional<String> urgent, Optional<String> done) {
    Todo res = new Todo();
    if (todoRepository.findById(id).isPresent()) {
      res = todoRepository.findById(id).get();
      res.setTitle(title);
      res.setUrgent(urgent.isPresent());
      res.setDone(done.isPresent());
      return todoRepository.save(res);
    }
    return res;
  }
}
