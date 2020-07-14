package com.greenfox.todosql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Assignee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;

  public Assignee() {

  }

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
