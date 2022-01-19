package com.polus.pos.services;

import java.util.List;

import com.polus.pos.dtos.SaleItemRequestDTO;
import com.polus.pos.entities.Sale;
import com.polus.pos.exceptions.DiscountNotFoundException;
import com.polus.pos.exceptions.ProductNotFoundException;
import com.polus.pos.exceptions.ProductOutOfStockException;

public interface SaleService {
  Sale createSale(List<SaleItemRequestDTO> items)
      throws ProductNotFoundException, DiscountNotFoundException, ProductOutOfStockException;
}
