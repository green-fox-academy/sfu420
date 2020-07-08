package com.greenfox.di.coloring.model;

import com.greenfox.di.hellodi.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedColor implements MyColor {


  @Autowired
  private Printer printer;

  @Override
  public void printColor() {
    printer.log("It is red in color...");
  }
}
