package com.example.uniclubjava.repository;

import com.example.uniclubjava.entity.Role;
import com.example.uniclubjava.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

   // Optional<Role> findByRole(String role);
}


