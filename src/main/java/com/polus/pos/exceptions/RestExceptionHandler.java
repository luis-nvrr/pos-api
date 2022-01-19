package com.polus.pos.exceptions;

import com.polus.pos.dtos.ExceptionResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(DiscountNotFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handle(DiscountNotFoundException e) {
    ExceptionResponseDTO response = new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ExceptionResponseDTO> handle(ProductNotFoundException e) {
    ExceptionResponseDTO response = new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(ProductOutOfStockException.class)
  public ResponseEntity<ExceptionResponseDTO> handle(ProductOutOfStockException e) {
    ExceptionResponseDTO response = new ExceptionResponseDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
