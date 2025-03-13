package com.example.uniclubjava.payload.request;


import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String fullname;
    private String password;

}

