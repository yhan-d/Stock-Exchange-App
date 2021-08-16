package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.repository.IClientRepository;
import com.kafein.stockexchangeapp.repository.IStockRepository;
import com.kafein.stockexchangeapp.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IStockRepository stockRepository;

    public Client findByUserName(String username){
        return clientRepository.findByUserName(username);
    }
    public Client findByUserEmail(String email){
        return clientRepository.findByUserEmail(email);
    }

    @Override
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }


    @Override
    public List<Stock> getAllOwnedStocks(long id) {
        return null;
    }
}
