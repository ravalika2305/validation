package com.example.stockdataService;


import com.example.stockdataDto.StockDataDto;
import java.util.List;

public interface StockDataService {
    StockDataDto createStockData(StockDataDto stockDataDto);
    List<StockDataDto> getAllStockData();
    StockDataDto getStockDataById(Integer id);
    StockDataDto updateStockData(Integer id, StockDataDto stockDataDto);
    void deleteStockData(Integer id);
}


