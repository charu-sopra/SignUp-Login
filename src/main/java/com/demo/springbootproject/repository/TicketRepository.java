package com.demo.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springbootproject.Entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}