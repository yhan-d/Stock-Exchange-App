package com.kafein.stockexchangeapp.controller;

import com.kafein.stockexchangeapp.entities.Client;
import com.kafein.stockexchangeapp.entities.Stock;

import com.kafein.stockexchangeapp.service.IAdminService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;



import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return adminService.getAllClients();
    }

    @PostMapping("/addClient")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        return new ResponseEntity<>(adminService.createClient(client), HttpStatus.CREATED);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable long id) {

        return new ResponseEntity<>(adminService.getClientById(id), HttpStatus.OK);
    }
    @GetMapping("/clientName/{id}")
    public ResponseEntity<String> getClientUserNameById(@PathVariable long id) {

        return new ResponseEntity<>(adminService.getClientUserNameById(id), HttpStatus.OK);
    }
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable long id, @RequestBody Client client) {

        return new ResponseEntity<>(adminService.updateClient(id, client), HttpStatus.OK);

    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable long id) {
        adminService.deleteClient(id);
        return new ResponseEntity<>("Kullanıcı silindi", HttpStatus.OK);
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return adminService.getAllStocks();
    }

    @PostMapping("/addStock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {

        return new ResponseEntity<>(adminService.createStock(stock), HttpStatus.CREATED);
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable long id) {

        return new ResponseEntity<>(adminService.getStockById(id), HttpStatus.OK);
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable long id, @RequestBody Stock stock) {

        return new ResponseEntity<>(adminService.updateStock(id, stock), HttpStatus.OK);

    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable long id) {
        adminService.deleteStock(id);
        return new ResponseEntity<>("Hisse senedi silindi", HttpStatus.OK);
    }


}