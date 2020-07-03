package com.greenfox.webshop.model;

import java.util.UUID;

public class ShopItem {
//  protected final UUID uuid;
  protected String name;
  protected String description;
  protected double price;
  protected Integer qtyOfStock;

  public ShopItem(String name, String description, double price, Integer qtyOfStock) {
//    this.uuid = UUID.randomUUID();
    this.name = name;
    this.description = description;
    this.price = price;
    this.qtyOfStock = qtyOfStock;
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

  public Integer getQtyOfStock() {
    return qtyOfStock;
  }
}
