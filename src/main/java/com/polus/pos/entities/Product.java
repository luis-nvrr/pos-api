package com.polus.pos.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
  @Id
  private long barCode;
  private String description;
  private double price;
  private int available;

  public Product(long barcode, String description, double price, int available) {
    this.barCode = barcode;
    this.description = description;
    this.price = price;
    this.available = available;
  }

  public void reduceAvailableBy(int quantity) {
    this.available -= quantity;
  }

  public boolean isInStock(int quantity) {
    return this.available - quantity >= 0;
  }
}
