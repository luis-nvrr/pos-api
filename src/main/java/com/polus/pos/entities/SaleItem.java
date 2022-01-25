package com.polus.pos.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class SaleItem {
  @Id
  private UUID id;

  @OneToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @OneToOne
  @JoinColumn(name = "discount_id")
  private Discount discount;
  @Column(name = "price")
  private double price;
  @Column(name = "quantity")
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