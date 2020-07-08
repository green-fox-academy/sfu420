package com.greenfox.di.coloring.model;

import org.springframework.stereotype.Service;

@Service
public class YellowColor implements MyColor {

  @Override
  public void printColor() {
    System.out.println("It is yellow in color...");
  }
}
