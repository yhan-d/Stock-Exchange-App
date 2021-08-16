package com.kafein.stockexchangeapp.service;



import com.kafein.stockexchangeapp.entities.User;
import com.kafein.stockexchangeapp.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait kullanıcı bulunamadı."));
    }

    @Override
    public User updateUser(long id, User user) {
        User updatedUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait kullanıcı bulunamadı."));
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setUserEmail(user.getUserEmail());
        updatedUser.setUserType(user.getUserType());
        updatedUser.setUserName(user.getUserName());
        updatedUser.setUserPassword(user.getUserPassword());


        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " numaralı id'ye ait kullanıcı bulunamadı."));

        userRepository.delete(user);

    }


    @Override
    public User findByUserEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }





}
