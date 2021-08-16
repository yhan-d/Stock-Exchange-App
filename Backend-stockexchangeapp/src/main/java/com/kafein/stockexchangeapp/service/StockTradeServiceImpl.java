package com.kafein.stockexchangeapp.service;


import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.StockTrade;
import com.kafein.stockexchangeapp.repository.IClientRepository;
import com.kafein.stockexchangeapp.repository.IStockRepository;
import com.kafein.stockexchangeapp.repository.IStockTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTradeServiceImpl implements IStockTradeService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IStockRepository stockRepository;

    @Autowired
    private IStockTradeRepository stockTradeRepository;

    public StockTradeServiceImpl(IStockTradeRepository stockTradeRepository) {
        this.stockTradeRepository = stockTradeRepository;
    }


    @Override
    public List<Stock> findByUserId(long id) {
        return stockTradeRepository.findByUserId(id);
    }

    @Override
    public List<Client> findByStockId(long id) {
        return stockTradeRepository.findByStockId(id);
    }

    @Override
    public StockTrade findStockTradeByClientAndStock(long clientId, long stockId) {
        return stockTradeRepository.findStockTradeByClientAndStock(clientId, stockId);
    }


    @Override
    public StockTrade saleStockByClientAndStock(long clientId, Stock stock, int redCount,int stockValue) {
        StockTrade st =  stockTradeRepository.findStockTradeByClientAndStock(clientId, stock.getStockId());
      st.setCount(st.getCount()-redCount);
      st.setTotalPrice(st.getTotalPrice() - redCount * stockValue);
      return stockTradeRepository.save(st);
    }

    @Override
    public StockTrade purchaseStockByClientAndStock(long clientId, Stock stock, int incCount,int stockValue) {
        StockTrade st = new StockTrade();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException(clientId + " numaralı id'ye ait kullanıcı bulunamadı."));
        Stock pStock = stockRepository.findById(stock.getStockId())
                .orElseThrow(() -> new RuntimeException(stock.getStockId() + " numaralı id'ye ait hisse bulunamadı."));
        st.setClient(client);
        st.setStock(pStock);
        st.setCount(incCount);
        st.setTotalPrice(stockValue);
        if(stockTradeRepository.findStockTradeByClientAndStock(st.getClient().getUserId(),st.getStock().getStockId()) != null ){
            st.setCount(st.getCount() + incCount);
            st.setTotalPrice(st.getTotalPrice() + incCount * stockValue);
            return stockTradeRepository.save(st);
        }else{
            return stockTradeRepository.save(st); }

    }


}
