package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.repository.IStockRepository;

import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;



import java.util.List;



@AllArgsConstructor
@Service
public class StockServiceImpl implements IStockService {

    
    private IStockRepository stockRepository;

    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock getStockById(long id){
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait hisse senedi bulunamadı."));
    }

    @Override
    public Stock updateStock(long id, Stock stock){
        Stock sampleStock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait hisse senedi bulunamadı."));
        sampleStock.setStockId(stock.getStockId());
        sampleStock.setStockCode(stock.getStockCode());
        sampleStock.setStockName(stock.getStockName());

        return stockRepository.save(sampleStock);

    }


    public void deleteStock(long id){
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait hisse senedi bulunamadı."));

        stockRepository.delete(stock);
        return;
    }


}
