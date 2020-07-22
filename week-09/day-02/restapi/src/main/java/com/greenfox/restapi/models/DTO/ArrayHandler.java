package com.greenfox.restapi.models.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ArrayHandler {

  private String what;
  private int[] numbers;

  public ArrayHandler(String what, int[] numbers) {
    this.what = what;
    this.numbers = numbers;
  }

  public int sum() {
    return Arrays.stream(numbers).sum();
  }

  public int multiply() {
    return Arrays.stream(numbers)
        .reduce(1, (a, b) -> a * b);
  }

  public List<Integer> doubleIt() {
    List<Integer> res = new ArrayList<>();
    Arrays.stream(numbers)
        .forEach(num -> res.add(num * 2));
    return res;
  }
}