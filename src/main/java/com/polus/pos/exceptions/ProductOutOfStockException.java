package com.polus.pos.exceptions;

public class ProductOutOfStockException extends Exception {
  public ProductOutOfStockException(String message) {
    super(message);
  }
}
