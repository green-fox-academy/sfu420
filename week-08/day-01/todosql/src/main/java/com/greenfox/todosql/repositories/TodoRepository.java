package com.greenfox.todosql.repositories;

import com.greenfox.todosql.models.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findTodoByDone(boolean done);
}
