package com.greenfox.webshop.model;

public class ShopItem {
  protected String name;
  protected String description;
  protected double price;
  protected Integer quantityOfStock;

  public ShopItem(String name, String description, double price, Integer quantityOfStock) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public Integer getQuantityOfStock() {
    return quantityOfStock;
  }
}
