package com.polus.pos.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.polus.pos.entities.Product;
import com.polus.pos.exceptions.ProductNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
  private Map<Long, Product> repository;

  public ProductRepositoryImpl() {
    this.repository = new HashMap<>();
  }

  @Override
  public Product findProductById(long id) throws ProductNotFoundException {
    Product foundProduct = this.repository.get(id);
    if (foundProduct == null)
      throw new ProductNotFoundException("Producto no encontrado");

    return foundProduct;
  }

  @Override
  public void saveProduct(Product product) {
    this.repository.put(product.getBarCode(), product);
  }

  @Override
  public List<Product> findAllProducts() {
    return new ArrayList<Product>(this.repository.values());
  }

}
