package com.polus.pos.services;

import java.util.List;

import com.polus.pos.dtos.ProductRequestDTO;
import com.polus.pos.entities.Product;
import com.polus.pos.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product createProduct(ProductRequestDTO productDTO) {
    long barCode = productDTO.getBarCode();
    String description = productDTO.getDescription();
    double price = productDTO.getPrice();
    int available = productDTO.getAvailable();

    Product newProduct = new Product(barCode, description, price, available);
    productRepository.saveProduct(newProduct);
    return newProduct;
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAllProducts();
  }

}
