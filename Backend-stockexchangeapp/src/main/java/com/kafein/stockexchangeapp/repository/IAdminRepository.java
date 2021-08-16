package com.kafein.stockexchangeapp.repository;

import com.kafein.stockexchangeapp.entities.Admin;
import com.kafein.stockexchangeapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByUserEmail(String email);
}
