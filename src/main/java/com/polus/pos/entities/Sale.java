package com.polus.pos.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Sale {
  @Id
  private UUID id;
  @Column(name = "items")
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<SaleItem> items;
  @Column(name = "date")
  private Date date;

  public Sale(List<SaleItem> items, Date date) {
    this.id = UUID.randomUUID();
    this.items = items;
    this.date = date;
  }
}