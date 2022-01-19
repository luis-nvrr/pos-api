package com.polus.pos.repositories;

import java.util.List;

import com.polus.pos.entities.Product;
import com.polus.pos.exceptions.ProductNotFoundException;

public interface ProductRepository {
  Product findProductById(long id) throws ProductNotFoundException;

  void saveProduct(Product product);

  List<Product> findAllProducts();
}
