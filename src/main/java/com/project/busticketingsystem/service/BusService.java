package com.project.busticketingsystem.service;

import com.project.busticketingsystem.model.Bus;
import com.project.busticketingsystem.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> getAllBusses() {
        return busRepository.findAll();
    }

    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }
}
