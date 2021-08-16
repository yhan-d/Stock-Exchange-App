package com.kafein.stockexchangeapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Client extends User{

    public Client() {
    }

    public Client(Long userId, String firstName, String lastName, String userEmail, String userName, String userPassword) {
        super(userId, firstName, lastName, userEmail, userName, userPassword);
       this.setUserType(UserType.CLIENT);
    }
}
