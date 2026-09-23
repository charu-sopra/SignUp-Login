package com.demo.springbootproject.controller;
// package com.demo.springbootproject.service.TicketService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootproject.dto.SignUpRequestDTO;
import com.demo.springbootproject.dto.SignUpResponseDTO;
import com.demo.springbootproject.dto.TicketRequestDTO;
import com.demo.springbootproject.dto.TicketResponseDTO;
import com.demo.springbootproject.service.TicketService;

import jakarta.validation.Valid;

@RestController 
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    public TicketResponseDTO ticket(@Valid @RequestBody TicketRequestDTO ticketRequestDTO) {
        return ticketService.createTicket(ticketRequestDTO);
    }

}
