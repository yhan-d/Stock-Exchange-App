package com.kafein.stockexchangeapp.controller;

import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.service.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class StockController {

    @Autowired
    private IStockService stockService;



    @GetMapping("/stocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock){

        return new ResponseEntity<Stock>(stockService.createStock(stock),HttpStatus.CREATED);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable long id){

        return new ResponseEntity<Stock>(stockService.getStockById(id), HttpStatus.OK);
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock stock){

        return new ResponseEntity<Stock>(stockService.updateStock(id,stock),HttpStatus.OK);

    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<String>deleteStock(@PathVariable long id){
        stockService.deleteStock(id);
        return new ResponseEntity<String>("Hisse senedi silindi",HttpStatus.OK) ;
    }


}
