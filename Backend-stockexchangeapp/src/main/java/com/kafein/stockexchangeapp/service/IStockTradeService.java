package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.StockTrade;


import java.util.List;


public interface IStockTradeService {
     List<Stock> findByUserId(long id);
     List<Client> findByStockId(long id);
     StockTrade   findStockTradeByClientAndStock(long clientId, long stockId);
     StockTrade saleStockByClientAndStock(long clientId, Stock stock, int redCount,int stockValue);
     StockTrade  purchaseStockByClientAndStock(long clientId, Stock stock, int count,int stockValue);


}
