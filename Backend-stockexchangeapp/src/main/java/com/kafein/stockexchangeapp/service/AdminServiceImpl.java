package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Client;

import com.kafein.stockexchangeapp.entities.Stock;


import com.kafein.stockexchangeapp.repository.IClientRepository;

import com.kafein.stockexchangeapp.repository.IStockRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@AllArgsConstructor
@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IStockRepository stockRepository;




    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait kullanıcı bulunamadı."));
    }

    @Override
    public String getClientUserNameById(long id) {
        return getClientById(id).getUserName();
    }

    @Override
    public Client updateClient(long id, Client client) {
        Client updatedClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait kullanıcı bulunamadı."));
        updatedClient.setFirstName(client.getFirstName());
        updatedClient.setLastName(client.getLastName());
        updatedClient.setUserEmail(client.getUserEmail());
        updatedClient.setUserType(client.getUserType());
        updatedClient.setUserName(client.getUserName());
        updatedClient.setUserPassword(client.getUserPassword());

        return clientRepository.save(updatedClient);
    }

    @Override
    public void deleteClient(long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait kullanıcı bulunamadı."));

        clientRepository.delete(client);

    }

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

    }


    public Client findByUserEmail(String email) {
        return clientRepository.findByUserEmail(email);
    }

    public Client findByUserName(String username) {
        return clientRepository.findByUserName(username);
    }


}
