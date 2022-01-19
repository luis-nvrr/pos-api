package com.polus.pos.dtos;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequestDTO {

  @Id
  private long barCode;
  private String description;
  private double price;
  private int available;

  public ProductRequestDTO(long barcode, String description, double price, int available) {
    this.barCode = barcode;
    this.description = description;
    this.price = price;
    this.available = available;
  }

}
