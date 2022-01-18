package com.polus.pos.repositories;

import java.util.Map;

import com.polus.pos.entities.Product;
import com.polus.pos.exceptions.ProductNotFoundException;

public class ProductRepositoryImpl implements ProductRepository {
  private Map<Long, Product> repository;

  @Override
  public Product findProductById(long id) throws ProductNotFoundException {
    Product foundProduct = this.repository.get(id);
    if (foundProduct == null)
      throw new ProductNotFoundException("Producto no encontrado");

    return foundProduct;
  }

}
