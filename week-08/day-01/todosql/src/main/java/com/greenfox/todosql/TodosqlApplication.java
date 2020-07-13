package com.greenfox.todosql;

import com.greenfox.todosql.models.Todo;
import com.greenfox.todosql.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodosqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodosqlApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner run(TodoRepository todoRepository) {
//    return args -> {
//      todoRepository.save(new Todo("Daily task", false, false));
//      todoRepository.save(new Todo("Make the beds", true, true));
//      todoRepository.save(new Todo("Do the washing up", true, false));
//      todoRepository.save(new Todo("Clean the bathroom and the kitchen", true, true));
//      todoRepository.save(new Todo("Wipe all the surfaces with a cloth", true, false));
//      todoRepository.save(new Todo("Remove the grease", true, true));
//      todoRepository.save(new Todo("Tidy up", false, false));
//      todoRepository.save(new Todo("Throw away the rubbish", true, true));
//      todoRepository.save(new Todo("Broom", true, false));
//      todoRepository.save(new Todo("Sweep the floor", true, true));
//      todoRepository.save(new Todo("Wash the floors", true, false));
//      todoRepository.save(new Todo("Mop", true, true));
//      todoRepository.save(new Todo("Vacuum the carpet", false, false));
//      todoRepository.save(new Todo("Vacuum cleaner / hoover", true, true));
//      todoRepository.save(new Todo("Dust the furniture", true, false));
//    };
//  }
}
