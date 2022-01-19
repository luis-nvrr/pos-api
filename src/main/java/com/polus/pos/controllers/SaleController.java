package com.polus.pos.controllers;

import com.polus.pos.dtos.SaleRequestDTO;
import com.polus.pos.entities.Sale;
import com.polus.pos.exceptions.DiscountNotFoundException;
import com.polus.pos.exceptions.ProductNotFoundException;
import com.polus.pos.exceptions.ProductOutOfStockException;
import com.polus.pos.services.SaleService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sales")
public class SaleController {
  private SaleService saleService;

  public SaleController(SaleService saleService) {
    this.saleService = saleService;
  }

  @PostMapping
  public ResponseEntity<Sale> createSale(@RequestBody SaleRequestDTO saleRequestDTO)
      throws ProductNotFoundException, DiscountNotFoundException, ProductOutOfStockException {
    return ResponseEntity.ok(saleService.createSale(saleRequestDTO.getItems()));
  }
}
