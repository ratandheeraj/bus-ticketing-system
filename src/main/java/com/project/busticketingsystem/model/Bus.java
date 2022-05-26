package com.project.busticketingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "busses")
public class Bus {
    private long busId;
    private int noOfSeats;
    private BusType busType;

    public Bus() {
    }

    public Bus(int noOfSeats, BusType busType) {
        this.noOfSeats = noOfSeats;
        this.busType = busType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    @Column(name = "no_of_seats", nullable = false)
    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    @Column(name = "bus_type", nullable = false)
    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }


    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", noOfSeats=" + noOfSeats +
                ", busType=" + busType +
                '}';
    }
}
