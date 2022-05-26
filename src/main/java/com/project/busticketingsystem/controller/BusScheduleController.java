package com.project.busticketingsystem.controller;

import com.project.busticketingsystem.model.BusSchedule;
import com.project.busticketingsystem.model.ReqBusSchedule;
import com.project.busticketingsystem.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BusScheduleController {
    @Autowired
    private BusScheduleService busScheduleService;

    @GetMapping("/bus-schedules")
    public List<BusSchedule> getAllBusSchedules(){
        return busScheduleService.getAllBusSchedules();
    }

    @PostMapping("/bus-schedule")
    public BusSchedule createBusSchedule(@Valid @RequestBody BusSchedule busSchedule){
        return busScheduleService.createBusSchedule(busSchedule);
    }

    @PostMapping("/bus-schedule-request")
    public List<BusSchedule> getBusSchedulesByDateAndPlace(@RequestBody ReqBusSchedule reqBusSchedule){
        return busScheduleService.getBusSchedulesByDateAndPlace(reqBusSchedule);
    }


//    @PutMapping("/bus-schedule-update/{id}")
//    public BusSchedule updateBusSchedule(@PathVariable("id") long busScheduleId){
//        System.out.println("hello");
//        System.out.println(busScheduleId);
//        return busScheduleService.updateNoOfSeatsBooked(busScheduleId,2);
//    }
}
