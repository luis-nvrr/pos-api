package com.polus.pos.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DiscountRequestDTO {
  private String description;
  private double percentage;
}
