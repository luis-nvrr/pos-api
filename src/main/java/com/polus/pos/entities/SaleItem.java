package com.polus.pos.entities;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleItem {
  private UUID id;
  private Product product;
  private Discount discount;
  private double price;
  private int quantity;

  public SaleItem(UUID id, Product product, Discount discount, int quantity) {
    this.id = id;
    this.product = product;
    this.discount = discount;
    this.price = calculatePriceWithDiscount();
    this.quantity = quantity;
  }

  public double calculatePriceWithDiscount() {
    if (this.discount == null) {
      return getProductPrice();
    }

    return getProductPrice() * (1 - (this.discount.getPercentage() / 100));
  }

  public double getProductPrice() {
    return this.product.getPrice();
  }
}