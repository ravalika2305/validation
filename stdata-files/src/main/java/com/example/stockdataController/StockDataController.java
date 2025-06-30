package com.example.stockdataController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.stockdataDto.StockDataDto;
import com.example.stockdataService.StockDataService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-data")
@Validated
public class StockDataController {

    @Autowired
    private StockDataService stockDataService;

    @PostMapping
    public ResponseEntity<StockDataDto> createStockData(@Valid @RequestBody StockDataDto stockDataDto) {
        return ResponseEntity.ok(stockDataService.createStockData(stockDataDto));
    }

    @GetMapping
    public ResponseEntity<List<StockDataDto>> getAllStockData() {
        return ResponseEntity.ok(stockDataService.getAllStockData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDataDto> getStockDataById(@PathVariable Integer id) {
        return ResponseEntity.ok(stockDataService.getStockDataById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDataDto> updateStockData(@PathVariable Integer id, @Valid @RequestBody StockDataDto stockDataDto) {
        return ResponseEntity.ok(stockDataService.updateStockData(id, stockDataDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStockData(@PathVariable Integer id) {
        stockDataService.deleteStockData(id);
        return ResponseEntity.ok("Stock data deleted successfully");
    }
}
