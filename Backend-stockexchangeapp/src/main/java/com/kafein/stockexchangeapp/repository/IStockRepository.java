package com.kafein.stockexchangeapp.repository;

import com.kafein.stockexchangeapp.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock,Long> {
}
