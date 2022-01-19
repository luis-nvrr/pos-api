package com.polus.pos.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.polus.pos.entities.Discount;
import com.polus.pos.exceptions.DiscountNotFoundException;

import org.springframework.stereotype.Repository;

@Repository
public class DiscountRepositoryImpl implements DiscountRepository {
  private Map<UUID, Discount> repository;

  public DiscountRepositoryImpl() {
    this.repository = new HashMap<>();
  }

  @Override
  public Discount findDiscountById(UUID id) throws DiscountNotFoundException {
    Discount discount = this.repository.get(id);
    if (discount == null) {
      throw new DiscountNotFoundException("descuentro no encontrado");
    }
    return discount;
  }

  @Override
  public void saveDiscount(Discount discount) {
    this.repository.put(discount.getId(), discount);
  }

}
