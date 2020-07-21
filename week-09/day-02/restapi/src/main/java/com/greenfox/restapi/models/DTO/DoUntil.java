package com.greenfox.restapi.models.DTO;

import lombok.Getter;

@Getter
public class DoUntil {

  private Integer result;

  public DoUntil sum(Integer until) {
    int res = 0;
    for (int i = 0; i <= until; i++) {
      res = res + i;
    }
    this.result = res;
    return this;
  }

  public DoUntil factor(Integer until) {
    int res = 1;
    for (int i = 1; i <= until; i++) {
      res = res * i;
    }
    this.result = res;
    return this;
  }
}
