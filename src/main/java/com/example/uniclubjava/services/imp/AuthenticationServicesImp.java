package com.example.uniclubjava.services.imp;

import com.example.uniclubjava.entity.User;
import com.example.uniclubjava.repository.UserRepository;
import com.example.uniclubjava.services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServicesImp implements AuthenticationServices {


    @Autowired
    private UserRepository userRepository;



    @Override
    public boolean authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.isPresent();
    }
}
