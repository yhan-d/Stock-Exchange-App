package com.kafein.stockexchangeapp.repository;

import com.kafein.stockexchangeapp.entities.Admin;
import com.kafein.stockexchangeapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
    Boolean existsByUserName(String username);
    Boolean existsByUserEmail(String email);

    Client findByUserEmail(String email);

    Client findByUserName(String username);
}
