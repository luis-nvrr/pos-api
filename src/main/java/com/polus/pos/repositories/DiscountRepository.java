package com.polus.pos.repositories;

import java.util.List;
import java.util.UUID;

import com.polus.pos.entities.Discount;
import com.polus.pos.exceptions.DiscountNotFoundException;

public interface DiscountRepository {
  Discount findDiscountById(UUID id) throws DiscountNotFoundException;

  void saveDiscount(Discount discount);

  List<Discount> findAllDiscount();
}
