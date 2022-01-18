package com.polus.pos.entities;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
}
