package com.kafein.stockexchangeapp;

import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.User;
import com.kafein.stockexchangeapp.entities.UserType;
import com.kafein.stockexchangeapp.repository.IStockRepository;
import com.kafein.stockexchangeapp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockExchangeApplication  {


	public static void main(String[] args) {

		SpringApplication.run(StockExchangeApplication.class, args);
	}


}