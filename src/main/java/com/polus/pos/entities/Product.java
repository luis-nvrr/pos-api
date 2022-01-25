package com.polus.pos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {
  @Id
  private long barCode;
  @Column(name = "description")
  private String description;
  @Column(name = "price")
  private double price;
  @Column(name = "available")
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
