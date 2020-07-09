package com.greenfox.foxclub.model;

import java.util.List;
import lombok.Data;

public @Data class Fox {
  protected String name;
  protected List<Trick> tricks;
  protected String food;
  protected String drink;

  public Fox(String name, List<Trick> tricks, String food, String drink) {
    this.name = name;
    this.tricks = tricks;
    this.food = food;
    this.drink = drink;
  }

  @Override
  public String toString() {
    return "This is " + this.name + ". Currently living on " + this.food + " and " + this.drink +
        ". Who knows " + this.tricks.size() + " tricks.";
  }

}