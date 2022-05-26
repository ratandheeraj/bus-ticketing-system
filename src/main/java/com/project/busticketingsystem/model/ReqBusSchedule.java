package com.project.busticketingsystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


public class ReqBusSchedule {
    private String toLocation;
    private String fromLocation;
    private LocalDate localDate;

    public ReqBusSchedule(String toLocation, String fromLocation, LocalDate localDate) {
        this.toLocation = toLocation;
        this.fromLocation = fromLocation;
        this.localDate = localDate;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
