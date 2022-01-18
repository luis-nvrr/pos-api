package com.polus.pos.entities;

import java.util.UUID;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SaleItem {
  private UUID id;
  private Product product;
  private Discount discount;
  private double price;

  public SaleItem(UUID id, Product product, Discount discount) {
    this.id = id;
    this.product = product;
    this.discount = discount;
    this.price = calculatePriceWithDiscount();
  }

  public double calculatePriceWithDiscount() {
    return getProductPrice() * (1 - (this.discount.getPercentage() / 100));
  }

  public double getProductPrice() {
    return this.product.getPrice();
  }
}