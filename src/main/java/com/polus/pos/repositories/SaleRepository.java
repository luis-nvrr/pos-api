package com.polus.pos.repositories;

import java.util.UUID;

import com.polus.pos.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
}
