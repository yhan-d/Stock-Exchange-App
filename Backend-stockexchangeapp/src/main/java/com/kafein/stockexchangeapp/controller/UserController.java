package com.kafein.stockexchangeapp.controller;

import com.kafein.stockexchangeapp.entities.Stock;
import com.kafein.stockexchangeapp.entities.User;
import com.kafein.stockexchangeapp.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createStock(@RequestBody User user){

        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){

        return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user){

        return new ResponseEntity<User>(userService.updateUser(id,user),HttpStatus.OK);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("Kullanıcı silindi",HttpStatus.OK) ;
    }

}
