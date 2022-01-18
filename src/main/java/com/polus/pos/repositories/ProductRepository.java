package com.polus.pos.repositories;

import com.polus.pos.entities.Product;
import com.polus.pos.exceptions.ProductNotFoundException;

public interface ProductRepository {
  Product findProductById(long id) throws ProductNotFoundException;
}
