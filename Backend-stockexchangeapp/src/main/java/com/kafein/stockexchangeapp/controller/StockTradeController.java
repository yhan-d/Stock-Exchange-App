package com.kafein.stockexchangeapp.controller;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.StockTrade;
import com.kafein.stockexchangeapp.service.IStockTradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/stocktrade/")
public class StockTradeController {

    @Autowired
    private IStockTradeService stockTradeService;

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Stock>> findByUserId(@PathVariable long id) {

        return new ResponseEntity<>(stockTradeService.findByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<List<Client>> findByStockId(@PathVariable long id) {

        return new ResponseEntity<>(stockTradeService.findByStockId(id), HttpStatus.OK);
    }

    @GetMapping("/{clientId}/{stockId}")
    public ResponseEntity<StockTrade> findByStockId(@PathVariable long clientId,@PathVariable long stockId) {

        return new ResponseEntity<>(stockTradeService.findStockTradeByClientAndStock(clientId,stockId), HttpStatus.OK);
    }

    @PutMapping("/saleStock/{clientId}")
    public ResponseEntity<StockTrade> saleStock(@PathVariable long clientId,@RequestBody Stock stock,int redCount,int stockValue) {

        return new ResponseEntity<>(stockTradeService.saleStockByClientAndStock(clientId,stock,redCount,stockValue), HttpStatus.OK);

    }

    @PostMapping("/purchaseStock/{clientId}")
    public ResponseEntity<StockTrade> purchaseStock(@PathVariable long clientId,@RequestBody Stock stock,int count, int stockValue){

        return new ResponseEntity<>(stockTradeService.purchaseStockByClientAndStock(clientId, stock, count,stockValue),HttpStatus.OK);
    }



}

