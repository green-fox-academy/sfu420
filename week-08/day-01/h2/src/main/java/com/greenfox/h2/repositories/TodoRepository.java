package com.greenfox.h2.repositories;

import com.greenfox.h2.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
