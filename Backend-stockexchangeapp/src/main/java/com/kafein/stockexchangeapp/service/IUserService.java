package com.kafein.stockexchangeapp.service;

import com.kafein.stockexchangeapp.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(long id);
    User updateUser(long id, User user);
    void deleteUser(long id);
    User findByUserName(String username);
    User findByUserEmail(String email);
}
