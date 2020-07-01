package com.greenfoxacademy.springstart.model;

public class Greeting {

  protected long greetCounter;
  protected String content;

  public Greeting(long greetCounter, String content) {
    this.greetCounter = greetCounter;
    this.content = content;
  }

  public long getGreetCounter() {
    return greetCounter;
  }

  public String getContent() {
    return content;
  }
}
