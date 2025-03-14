package com.example.uniclubjava.controller;


import com.example.uniclubjava.payload.request.SignUpRequest;
import com.example.uniclubjava.payload.response.BaseResponse;
import com.example.uniclubjava.services.AuthenticationServices;
import com.example.uniclubjava.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    @Autowired
    private UserServices userServices;


    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){

        try {
            boolean isSuccess = userServices.signup(signUpRequest);

            BaseResponse response = new BaseResponse();
            response.setCode(0);
            response.setMessage("Success!");
            response.setData(isSuccess);

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            BaseResponse response = new BaseResponse();
            response.setCode(1);
            response.setMessage(e.getMessage()); // Trả về thông báo lỗi cụ thể
            response.setData(false);
            return ResponseEntity.badRequest().body(response);
        }

    }
}
