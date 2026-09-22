package com.demo.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.demo.springbootproject.User;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


