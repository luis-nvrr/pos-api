package com.polus.pos.services;

import java.util.List;

import com.polus.pos.dtos.ProductRequestDTO;
import com.polus.pos.entities.Product;

public interface ProductService {
  Product createProduct(ProductRequestDTO productDTO);

  List<Product> getAllProducts();
}
