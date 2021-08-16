package com.kafein.stockexchangeapp.controller;

import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.service.IClientService;
import com.kafein.stockexchangeapp.service.IStockTradeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return clientService.getAllStocks();
    }


    @GetMapping("/stocks/{id}")
    public List<Stock> getAllOwnedStocks(long id) {
        return null;
    }
}
