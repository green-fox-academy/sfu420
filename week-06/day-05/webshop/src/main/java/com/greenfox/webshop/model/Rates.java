package com.greenfox.webshop.model;

import java.util.HashMap;

public class Rates {
  protected HashMap<String, Double> rates = new HashMap<>();
  protected String base;
  protected String date;

  public Rates() {

  }

  public Rates(HashMap<String, Double> rates, String base, String date) {
    this.rates = rates;
    this.base = base;
    this.date = date;
  }

  public HashMap<String, Double> getRates() {
    return rates;
  }

  public void setRates(HashMap<String, Double> rates) {
    this.rates = rates;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Base : " + this.base + '\n' +  "Date : " + this.date + '\n' + "Rates : " + this.rates.toString();
  }
}

