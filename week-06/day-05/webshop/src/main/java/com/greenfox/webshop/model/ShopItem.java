package com.greenfox.webshop.model;

public class ShopItem {
  protected String name;
  protected String description;
  protected double price;
  protected Integer qtyOfStock;
  protected ProductCategory type;
      //TODO This supposed to be not String, but a new class which is extendable by user

  public ShopItem(String name, ProductCategory type, String description, double price,
                  Integer qtyOfStock) {
    this.name = name;
    this.type = type;
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

  public ProductCategory getType() {
    return type;
  }

  public String getProductCategory() {
    if (this.type == ProductCategory.CLOTHES_SHOES) {
      return "Beverages and Snacks";
    } else if (this.type == ProductCategory.ELECTRONICS) {
      return "Electronics";
    } else {
      return "Beverages and Snacks";
    }
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
