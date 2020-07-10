package com.greenfox.foxclub.model;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data public class Fox {
  private String name;
  private ArrayList<Trick> tricks;
  private String food;
  private String drink;

  public void addTrick(Trick trick) {
    this.tricks.add(trick);
  }

  @Override
  public String toString() {
    return "This is " + this.name + ". Currently living on " + this.food + " and " + this.drink +
        " and knows " + this.tricks.size() + " tricks.";
  }

}