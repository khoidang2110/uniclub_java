package com.example.uniclubjava.repository;

import com.example.uniclubjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // select find
    //where by


    // kiểu dữ liệu optional: xử lý,  tránh thiếu sót khi xử lý null
    Optional<User> findByEmailAndPassword(String email, String password);

    // Tìm kiếm user theo email để kiểm tra trước khi tạo mới
    Optional<User> findByEmail(String email);
}
