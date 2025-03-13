package com.example.uniclubjava.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="users")
public class User {


    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String fullname;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role roles;

}
