package com.polus.pos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.polus.pos.dtos.DiscountRequestDTO;
import com.polus.pos.entities.Discount;
import com.polus.pos.exceptions.DiscountNotFoundException;
import com.polus.pos.repositories.DiscountRepository;

import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {
  private DiscountRepository discountRepository;

  public DiscountServiceImpl(DiscountRepository discountRepository) {
    this.discountRepository = discountRepository;
  }

  @Override
  public Discount createDiscount(DiscountRequestDTO discountRequest) {
    UUID id = UUID.randomUUID();
    String description = discountRequest.getDescription();
    double percentage = discountRequest.getPercentage();
    Date dateNow = new Date();

    Discount discount = new Discount(id, description, percentage, dateNow);
    this.discountRepository.save(discount);
    return discount;
  }

  @Override
  public Discount findDiscountById(UUID id) throws DiscountNotFoundException {
    Optional<Discount> savedDiscount = this.discountRepository.findById(id);
    if (savedDiscount.isEmpty()) {
      throw new DiscountNotFoundException("Descuento inválido");
    }
    return savedDiscount.get();
  }

  @Override
  public List<Discount> listAllDiscounts() {
    return this.discountRepository.findAll();
  }

}
