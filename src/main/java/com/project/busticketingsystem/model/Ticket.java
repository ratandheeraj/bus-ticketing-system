package com.project.busticketingsystem.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tickets")
public class Ticket {
    private long ticketId;
    private int noOfSeats;
    private long userId;
    private long busScheduleId;

    public Ticket() {
    }

    public Ticket(int noOfSeats, long userId, long busScheduleId) {
        this.noOfSeats = noOfSeats;
        this.userId = userId;
        this.busScheduleId = busScheduleId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    @Column(name = "no_of_seats", nullable = false)
    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "bus_schedule_id", nullable = false)
    public long getBusScheduleId() {
        return busScheduleId;
    }

    public void setBusScheduleId(long busSchedule) {
        this.busScheduleId = busSchedule;
    }
}
