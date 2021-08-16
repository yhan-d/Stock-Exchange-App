package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.List;

public interface IAdminService {

    List<Client> getAllClients();
    Client createClient(Client client);
    Client getClientById(long id);
    String getClientUserNameById(long id);
    Client updateClient(long id, Client client);
    void deleteClient(long id);
    List<Stock> getAllStocks();
    Stock createStock(Stock stock);
    Stock getStockById(long id);
    Stock updateStock(long id,Stock stock);
    void deleteStock(long id);
    Client findByUserEmail(String email);
    Client findByUserName(String username);


}
