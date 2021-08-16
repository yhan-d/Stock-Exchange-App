package com.kafein.stockexchangeapp.repository;

import com.kafein.stockexchangeapp.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
   // Role findByRole(String role);
}
