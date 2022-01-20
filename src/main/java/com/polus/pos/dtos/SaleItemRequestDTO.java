package com.polus.pos.dtos;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleItemRequestDTO {
  private long productId;
  private UUID discountId;
  private int quantity;

  public boolean hasDiscount() {
    return discountId != null;
  }
}
