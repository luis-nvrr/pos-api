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
import com.polus.pos.exceptions.ProductOutOfStockException;
import com.polus.pos.repositories.DiscountRepository;
import com.polus.pos.repositories.ProductRepository;
import com.polus.pos.repositories.SaleRepository;

import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
  private SaleRepository saleRepository;
  private ProductRepository productRepository;
  private DiscountRepository discountRepository;

  public SaleServiceImpl(SaleRepository saleRepository, ProductRepository productRepository,
      DiscountRepository discountRepository) {
    this.saleRepository = saleRepository;
    this.productRepository = productRepository;
    this.discountRepository = discountRepository;
  }

  @Override
  public Sale createSale(List<SaleItemRequestDTO> saleRequestItems)
      throws ProductNotFoundException, DiscountNotFoundException, ProductOutOfStockException {
    List<SaleItem> saleItems = new ArrayList<>();

    for (SaleItemRequestDTO item : saleRequestItems) {
      UUID id = UUID.randomUUID();
      Product saleProduct = productRepository.findProductById(item.getProductId());
      int quantity = item.getQuantity();

      if (!saleProduct.isInStock(quantity)) {
        throw new ProductOutOfStockException("producto fuera de stock");
      }

      Discount saleDiscount = null;
      if (item.hasDiscount()) {
        saleDiscount = discountRepository.findDiscountById(item.getDiscountId());
      }

      SaleItem saleItem = new SaleItem(id, saleProduct, saleDiscount, quantity);
      saleItems.add(saleItem);

      saleProduct.reduceAvailableBy(quantity);
      productRepository.saveProduct(saleProduct);
    }

    Sale newSale = new Sale(saleItems, new Date());
    Sale savedSale = saleRepository.saveSale(newSale);

    return savedSale;
  }

}
