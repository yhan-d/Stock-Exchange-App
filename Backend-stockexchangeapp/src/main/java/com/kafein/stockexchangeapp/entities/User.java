package com.kafein.stockexchangeapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.*;


@Entity
@Table(name="users")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discVal", discriminatorType = DiscriminatorType.INTEGER)
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private Long userId;

    @NotEmpty(message = "İsim boş bırakılamaz")
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotEmpty(message = "Soyisim boş bırakılamaz")
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @NotEmpty(message = "Email boş bırakılamaz")
    @Column(name = "user_email",nullable = false,unique = true)
    private String userEmail ;

    @Column(name = "user_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @NotEmpty(message = "Kullanıcı ismi boş bırakılamaz")
    @Column(name = "user_name",nullable = false,unique = true)
    private String userName;

    @NotEmpty(message = "Şifre boş bırakılamaz")
    @Column(name = "user_password",length = 8,nullable = false)
    private String userPassword;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles ;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "client", cascade = {CascadeType.ALL})
    private Set<StockTrade> stockTrades = new HashSet<>();

    public User() {
    }

    public User(Long userId, String firstName, String lastName, String userEmail, String userName, String userPassword) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(Long userId, String firstName, String lastName, String userEmail, UserType userType, String userName, String userPassword) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }



    public User(String firstName, String lastName, String userEmail, UserType userType,
                String userName, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }


    public User(String firstName, String lastName, String userEmail, String userName, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return userId != null && userId.equals(((User) o).userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, userEmail, userType, userName, userPassword);
    }


}