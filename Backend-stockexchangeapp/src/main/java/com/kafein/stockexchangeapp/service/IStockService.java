package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Stock;


import java.util.Date;
import java.util.List;

public interface IStockService {
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    Stock getStockById(long id);
    Stock updateStock(long id, Stock stock);
    void deleteStock(long id);


}
