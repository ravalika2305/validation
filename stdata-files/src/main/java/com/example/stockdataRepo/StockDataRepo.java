package com.example.stockdataRepo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stockdataEntity.StockDataEntity;

public interface StockDataRepo extends JpaRepository<StockDataEntity, Integer> {
}



