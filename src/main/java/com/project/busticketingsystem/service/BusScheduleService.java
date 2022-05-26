package com.project.busticketingsystem.service;

import com.project.busticketingsystem.model.Bus;
import com.project.busticketingsystem.model.BusSchedule;
import com.project.busticketingsystem.model.ReqBusSchedule;
import com.project.busticketingsystem.repository.BusRepository;
import com.project.busticketingsystem.repository.BusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusScheduleService {
    @Autowired
    private BusScheduleRepository busScheduleRepository;
    @Autowired
    private BusRepository busRepository;

    public List<BusSchedule> getAllBusSchedules(){
        return busScheduleRepository.findAll();
    }

    public BusSchedule createBusSchedule(BusSchedule busSchedule) {
        Optional<Bus> busData = busRepository.findById(busSchedule.getBusId());
        if(busData.isEmpty()){
            return null;
        }
        return busScheduleRepository.save(busSchedule);
    }

    public BusSchedule updateNoOfSeatsBooked(long busScheduleId, int noOfSeatsBooked)
    {
        Optional<BusSchedule> busScheduleData = busScheduleRepository.findById(busScheduleId);
        if (busScheduleData.isPresent()) {
            BusSchedule busSchedule = busScheduleData.get();

            // To check whether it is exceeding total no of tickets in a bus
            Optional<Bus> busData = busRepository.findById(busSchedule.getBusId());
            Bus bus = busData.get();

            if(busSchedule.getNoOfSeatsBooked()+noOfSeatsBooked > bus.getNoOfSeats()){
                return null;
            }

            busSchedule.setNoOfSeatsBooked(busSchedule.getNoOfSeatsBooked()+noOfSeatsBooked);

            return busScheduleRepository.save(busSchedule);
        } else {
            return null;
        }
    }
    public List<BusSchedule> getBusSchedulesByDateAndPlace(ReqBusSchedule reqBusSchedule){
        LocalDate date = reqBusSchedule.getLocalDate();
        String fromLocation = reqBusSchedule.getFromLocation();
        String toLocation = reqBusSchedule.getToLocation();

        List<BusSchedule> busSchedules =  busScheduleRepository.findAll();
        List<BusSchedule> resultSchedules = new ArrayList<>();
        for (BusSchedule busSchedule:busSchedules) {
            if(busSchedule.getDate().isEqual(date) && busSchedule.getFromLocation().equals(fromLocation) && busSchedule.getToLocation().equals(toLocation)){
                resultSchedules.add(busSchedule);
            }
        }
        return resultSchedules;
    }
}
