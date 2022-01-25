package com.polus.pos.repositories;

import java.util.UUID;
import com.polus.pos.entities.Discount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, UUID> {
}
