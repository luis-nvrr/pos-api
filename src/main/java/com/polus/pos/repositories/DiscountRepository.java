package com.polus.pos.repositories;

import java.util.UUID;

import com.polus.pos.entities.Discount;
import com.polus.pos.exceptions.DiscountNotFoundException;

public interface DiscountRepository {
  Discount findDiscountById(UUID id) throws DiscountNotFoundException;
}
