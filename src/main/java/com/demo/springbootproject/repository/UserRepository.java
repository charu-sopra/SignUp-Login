package com.demo.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootproject.Entity.UserEntity;
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}


