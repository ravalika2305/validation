package com.example.stockdataServiceimp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.stockdataDto.StockDataDto;
import com.example.stockdataEntity.StockDataEntity;
import com.example.stockdataException.ResourceNotFoundException;
import com.example.stockdataRepo.StockDataRepo;
import com.example.stockdataService.StockDataService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockDataServiceImp implements StockDataService {

    @Autowired
    private StockDataRepo stockDataRepo;

    @Override
    public StockDataDto createStockData(StockDataDto stockDataDto) {
        StockDataEntity stockData = dtoToEntity(stockDataDto);
        StockDataEntity savedStockData = stockDataRepo.save(stockData);
        return entityToDto(savedStockData);
    }

    @Override
    public List<StockDataDto> getAllStockData() {
        return stockDataRepo.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StockDataDto getStockDataById(Integer id) {
        StockDataEntity stockData = stockDataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockData not found with id: " + id));
        return entityToDto(stockData);
    }

    @Override
    public StockDataDto updateStockData(Integer id, StockDataDto stockDataDto) {
        StockDataEntity stockData = stockDataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockData not found with id: " + id));

        stockData.setCompanyCode(stockDataDto.getCompanyCode());
        stockData.setT1(stockDataDto.getT1());
        stockData.setT2(stockDataDto.getT2());
        stockData.setT3(stockDataDto.getT3());
        stockData.setStockOrderType(stockDataDto.getStockOrderType());

        StockDataEntity updatedStockData = stockDataRepo.save(stockData);
        return entityToDto(updatedStockData);
    }

    @Override
    public void deleteStockData(Integer id) {
        StockDataEntity stockData = stockDataRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockData not found with id: " + id));
        stockDataRepo.delete(stockData);
    }

    private StockDataEntity dtoToEntity(StockDataDto dto) {
        return new StockDataEntity(dto.getId(), dto.getCompanyCode(), dto.getT1(), dto.getT2(), dto.getT3(), dto.getStockOrderType());
    }

    private StockDataDto entityToDto(StockDataEntity entity) {
        return new StockDataDto(entity.getId(), entity.getCompanyCode(), entity.getT1(), entity.getT2(), entity.getT3(), entity.getStockOrderType());
    }
}
