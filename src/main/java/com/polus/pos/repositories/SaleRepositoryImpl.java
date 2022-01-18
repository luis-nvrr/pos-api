package com.polus.pos.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.polus.pos.entities.Sale;

public class SaleRepositoryImpl implements SaleRepository {

  private Map<UUID, Sale> repository;

  public SaleRepositoryImpl() {
    this.repository = new HashMap<>();
  }

  @Override
  public Sale saveSale(Sale sale) {
    this.repository.put(sale.getId(), sale);
    return sale;
  }

}
