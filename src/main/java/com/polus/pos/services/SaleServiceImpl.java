package com.polus.pos.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.polus.pos.dtos.SaleItemRequestDTO;
import com.polus.pos.entities.Discount;
import com.polus.pos.entities.Product;
import com.polus.pos.entities.Sale;
import com.polus.pos.entities.SaleItem;
import com.polus.pos.exceptions.DiscountNotFoundException;
import com.polus.pos.exceptions.ProductNotFoundException;
import com.polus.pos.repositories.DiscountRepository;
import com.polus.pos.repositories.ProductRepository;
import com.polus.pos.repositories.SaleRepository;

public class SaleServiceImpl implements SaleService {
  private SaleRepository saleRepository;
  private ProductRepository productRepository;
  private DiscountRepository discountRepository;

  @Override
  public Sale createSale(List<SaleItemRequestDTO> saleRequestItems)
      throws ProductNotFoundException, DiscountNotFoundException {
    List<SaleItem> saleItems = new ArrayList<>();

    for (SaleItemRequestDTO item : saleRequestItems) {
      Product saleProduct = productRepository.findProductById(item.getProductId());
      Discount saleDiscount = null;
      if (item.hasDiscount()) {
        saleDiscount = discountRepository.findDiscountById(item.getDiscountId());
      }
      UUID id = UUID.randomUUID();
      SaleItem saleItem = new SaleItem(id, saleProduct, saleDiscount);
      saleItems.add(saleItem);
    }

    Sale newSale = new Sale(saleItems, new Date());
    Sale savedSale = saleRepository.saveSale(newSale);

    return savedSale;
  }

}
