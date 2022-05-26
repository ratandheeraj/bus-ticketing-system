package com.project.busticketingsystem.service;

import com.project.busticketingsystem.model.BusSchedule;
import com.project.busticketingsystem.model.Ticket;
import com.project.busticketingsystem.model.User;
import com.project.busticketingsystem.repository.BusScheduleRepository;
import com.project.busticketingsystem.repository.TicketRepository;
import com.project.busticketingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private BusScheduleService busScheduleService;

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketByUserId(long userId){
        List<Ticket> allTickets = ticketRepository.findAll();
        List<Ticket> ticketsByUser = new ArrayList<>();
        for (Ticket ticket:allTickets) {
            if(ticket.getUserId() == userId){
                ticketsByUser.add(ticket);
            }
        }
        return ticketsByUser;
    }

    public Ticket createTicket(Ticket ticket){
        Optional<User> userData = userRepository.findById(ticket.getUserId());
        Optional<BusSchedule> busScheduleData =  busScheduleRepository.findById(ticket.getBusScheduleId());
        if(userData.isEmpty() || busScheduleData.isEmpty()){
            return null;
        }
        BusSchedule busSchedule = busScheduleService.updateNoOfSeatsBooked(ticket.getBusScheduleId(),ticket.getNoOfSeats());
        if(busSchedule != null){
            return ticketRepository.save(ticket);
        }
        return null;
    }
}
