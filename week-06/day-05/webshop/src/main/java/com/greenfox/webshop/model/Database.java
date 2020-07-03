package com.greenfox.webshop.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

  List<ShopItem> products = new ArrayList<>(Arrays.asList(
     new ShopItem("Running shoes", "Nike running shoes for every day sport", 1000, 5),
     new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2),
     new ShopItem("Coca cola", "0.5l standard coke", 25,0),
     new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100),
     new ShopItem("T-shirt Nike", "Blue with a corgi on a bike", 300,1)
  ));

  public List<ShopItem> getProducts() {
    return products;
  }

  public void addProduct(ShopItem newProduct) {
    this.products.add(newProduct);
  }
}
