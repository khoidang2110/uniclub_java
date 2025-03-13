package com.example.uniclubjava.controller;


import com.example.uniclubjava.payload.response.BaseResponse;
import com.example.uniclubjava.services.AuthenticationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * {
 *     "code":200,
 *     "message":"",
 *     "data":""
 * }
 */






@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationServices authenticationServices;


    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password){

        boolean isSuccess = authenticationServices.authenticate(email,password);

        BaseResponse response = new BaseResponse();
        response.setData(isSuccess);
        response.setMessage(isSuccess ? "Success !" : "Failure !");
        response.setCode(isSuccess ? 0 :1 );

        return ResponseEntity.ok(response);

     //   return ResponseEntity.ok(isSuccess);
    }
}
