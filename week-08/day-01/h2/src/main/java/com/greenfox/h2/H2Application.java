package com.greenfox.h2;

import com.greenfox.h2.models.Todo;
import com.greenfox.h2.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2Application {

  public static void main(String[] args) {
    SpringApplication.run(H2Application.class, args);
  }

  @Bean
  public CommandLineRunner run(TodoRepository todoRepository) {
    return args -> {
      todoRepository.save(new Todo("Start the day"));
      todoRepository.save(new Todo("Finish H2 workshop1"));
      todoRepository.save(new Todo("Finish JPA workshop2"));
      todoRepository.save(new Todo("Create a CRUD project"));
    };
  }
}
