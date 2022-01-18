package com.polus.pos.repositories;

import com.polus.pos.entities.Sale;

public interface SaleRepository {
  Sale saveSale(Sale sale);
}
