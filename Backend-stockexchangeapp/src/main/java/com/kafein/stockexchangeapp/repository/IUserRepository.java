package com.kafein.stockexchangeapp.repository;



import com.kafein.stockexchangeapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByUserEmail(String email);
    User findByUserEmail(String email);


}
