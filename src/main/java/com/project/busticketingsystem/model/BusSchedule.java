package com.project.busticketingsystem.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "busSchedules")
public class BusSchedule {
    private long busScheduleId;
    private long busId;
    private String fromLocation;
    private String toLocation;
    private LocalDate date;
    private int noOfSeatsBooked;

    public BusSchedule() {
    }

    public BusSchedule(long busId, String fromLocation, String toLocation, LocalDate date, int noOfSeatsBooked) {
        this.busId = busId;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.date = date;
        this.noOfSeatsBooked = noOfSeatsBooked;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBusScheduleId() {
        return busScheduleId;
    }

    public void setBusScheduleId(long busScheduleId) {
        this.busScheduleId = busScheduleId;
    }

    @Column(name = "bus_id", nullable = false)
    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    @Column(name = "from_location", nullable = false)
    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    @Column(name = "to_location", nullable = false)
    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    @Column(name = "date", nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "no_of_seats_booked", nullable = false)
    public int getNoOfSeatsBooked() {
        return noOfSeatsBooked;
    }

    public void setNoOfSeatsBooked(int noOfSeatsBooked) {
        this.noOfSeatsBooked = noOfSeatsBooked;
    }
}
