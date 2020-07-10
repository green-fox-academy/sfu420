package com.greenfox.foxclub.model;

import java.util.ArrayList;
import lombok.Data;

public @Data class Fox {
  private String name;
  private ArrayList<Trick> tricks;
  private String food;
  private String drink;

  public Fox(String name, ArrayList<Trick> tricks, String food, String drink) {
    this.name = name;
    this.tricks = tricks;
    this.food = food;
    this.drink = drink;
  }

  public void addTrick(Trick trick) {
    this.tricks.add(trick);
  }

  @Override
  public String toString() {
    return "This is " + this.name + ". Currently living on " + this.food + " and " + this.drink +
        ". Who knows " + this.tricks.size() + " tricks.";
  }

}