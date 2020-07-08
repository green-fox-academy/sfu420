package com.greenfox.di;

import com.greenfox.di.coloring.model.RedColor;
import com.greenfox.di.hellodi.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiApplication implements CommandLineRunner {

  private Printer printer;
  private RedColor redcolor;

  @Autowired
  DiApplication(Printer printer, RedColor redcolor) {
    this.printer = printer;
    this.redcolor = redcolor;
  }

  public static void main(String[] args) {
    SpringApplication.run(DiApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    printer.log("hello");
    redcolor.printColor();
  }

}
