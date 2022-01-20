package com.polus.pos.controllers;

import java.util.List;
import java.util.UUID;

import com.polus.pos.dtos.DiscountRequestDTO;
import com.polus.pos.entities.Discount;
import com.polus.pos.exceptions.DiscountNotFoundException;
import com.polus.pos.services.DiscountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discounts")
public class DiscountController {
  private DiscountService discountService;

  private DiscountController(DiscountService discountService) {
    this.discountService = discountService;
  }

  @GetMapping
  public ResponseEntity<List<Discount>> getDiscounts() {
    return ResponseEntity.ok(discountService.listAllDiscounts());
  }

  @PostMapping
  public ResponseEntity<Discount> createDiscount(@RequestBody DiscountRequestDTO discountRequest) {
    return ResponseEntity.ok(discountService.createDiscount(discountRequest));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Discount> findDiscountById(@PathVariable UUID id) throws DiscountNotFoundException {
    return ResponseEntity.ok(discountService.findDiscountById(id));
  }
}
