package com.greenfox.restapi.models.DTO;

import lombok.Getter;

@Getter
public class Doubling {
  public Integer received;
  public Integer result;

  public Doubling(Integer received) {
    this.received = received;
    this.result = received * 2;
  }
}
