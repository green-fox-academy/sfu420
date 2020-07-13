package com.greenfox.h2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private boolean urgent = false;
  private boolean done = false;

  public Todo() {
    this.title = "";
  }

  public Todo(String title) {
    this.title = title;
    this.urgent = false;
    this.done = false;
  }
}
