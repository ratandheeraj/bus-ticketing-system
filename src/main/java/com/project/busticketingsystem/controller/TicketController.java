package com.project.busticketingsystem.controller;
import com.project.busticketingsystem.model.Ticket;
import com.project.busticketingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/ticket/{userId}")
    public List<Ticket> getTicketByUserId(@PathVariable("userId") long userId){
        return ticketService.getTicketByUserId(userId);
    }

    @PostMapping("/ticket")
    public Ticket createticket(@Valid @RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }
}
