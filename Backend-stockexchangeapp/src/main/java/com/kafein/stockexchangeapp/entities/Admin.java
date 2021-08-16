package com.kafein.stockexchangeapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User{

    public Admin() {
    }

    public Admin(Long userId, String firstName, String lastName, String userEmail, String userName, String userPassword) {
        super(userId, firstName, lastName, userEmail, userName, userPassword);
        this.setUserType(UserType.ADMIN);
    }

}
