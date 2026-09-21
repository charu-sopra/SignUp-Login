package com.demo.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootproject.User;
public interface UserRepository extends JpaRepository<User, Long> {

}


