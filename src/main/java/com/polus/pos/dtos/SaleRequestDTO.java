package com.polus.pos.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleRequestDTO {
  private List<SaleItemRequestDTO> items;
}
