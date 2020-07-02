package com.greenfox.simba.model;

public class BankAccount {

  protected String name;
  protected float balance;
  protected String animalType;

  public BankAccount(String name, float balance, String animalType) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
  }

  public String getName() {
    return name;
  }

  public float getBalance() {
    return balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public String isKing() {
    if (this.animalType.equals("lion")) {
      return "king";
    }
    return "";
  }

  public Boolean isKingBoolean() {
    if (this.animalType.equals("lion")) {
      return true;
    }
    return false;
  }

  public void raiseBalance() {
    if (this.isKingBoolean()) {
      this.balance += 100;
    } else {
      this.balance += 10;
    }
  }
}
