package com.polus.pos.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Sale {
  private UUID id;
  private List<SaleItem> items;
  private Date date;

  public Sale(List<SaleItem> items, Date date) {
    this.id = UUID.randomUUID();
    this.items = items;
    this.date = date;
  }
}