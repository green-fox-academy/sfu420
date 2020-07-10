package com.greenfox.foxclub.model;

import com.greenfox.foxclub.service.LoggingService;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data public class Fox {
  private String name;
  private ArrayList<Trick> tricks;
  private String food;
  private String drink;

//  private LoggingService logging;

//  public Fox(String name, ArrayList<Trick> tricks, String food, String drink) {
//    this.name = name;
//    this.tricks = tricks;
//    this.food = food;
//    this.drink = drink;
//  }

//  public Fox(LoggingService logging) {
//    this.logging = logging;
//  }

  public void addTrick(Trick trick) {
    this.tricks.add(trick);
  }

  @Override
  public String toString() {
    return "This is " + this.name + ". Currently living on " + this.food + " and " + this.drink +
        " and knows " + this.tricks.size() + " tricks.";
  }

}