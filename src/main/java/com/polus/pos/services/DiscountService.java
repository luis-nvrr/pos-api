package com.polus.pos.services;

import java.util.List;
import java.util.UUID;

import com.polus.pos.dtos.DiscountRequestDTO;
import com.polus.pos.entities.Discount;
import com.polus.pos.exceptions.DiscountNotFoundException;

public interface DiscountService {
  Discount createDiscount(DiscountRequestDTO discount);

  Discount findDiscountById(UUID id) throws DiscountNotFoundException;

  List<Discount> listAllDiscounts();
}
