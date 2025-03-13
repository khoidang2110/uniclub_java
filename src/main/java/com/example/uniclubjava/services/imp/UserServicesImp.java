package com.example.uniclubjava.services.imp;


import com.example.uniclubjava.entity.Role;
import com.example.uniclubjava.entity.User;
import com.example.uniclubjava.payload.request.SignUpRequest;
import com.example.uniclubjava.repository.RoleRepository;
import com.example.uniclubjava.repository.UserRepository;
import com.example.uniclubjava.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServicesImp implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean signup(SignUpRequest request) {

        String email = request.getEmail();
        if (!isValidEmail(email)) {
            throw new RuntimeException("Invalid email format!");
        }
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email '" + request.getEmail() + "' already exists!");
        }

        // Lấy role mặc định từ database
        Role defaultRole = roleRepository.findById(2)
                .orElseThrow(() -> new RuntimeException("Role not found!"));

        // Tạo user mới
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // ⚠️ Nên hash password trước khi lưu
        user.setFullname(request.getFullname());
        user.setRoles(defaultRole);

        userRepository.save(user);
        return true;
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
