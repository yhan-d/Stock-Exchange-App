package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;

import java.util.List;

public interface IClientService {
    List<Stock> getAllStocks();
    List<Stock> getAllOwnedStocks(long id);
    Client findByUserName(String username);
    Client findByUserEmail(String email);

}
