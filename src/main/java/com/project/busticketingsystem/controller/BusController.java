package com.project.busticketingsystem.controller;

import com.project.busticketingsystem.model.Bus;
import com.project.busticketingsystem.repository.BusRepository;
import com.project.busticketingsystem.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/busses")
    public List<Bus> getAllBusses() {
        return busService.getAllBusses();
    }

    @PostMapping("/bus")
    public Bus createBus(@Valid @RequestBody Bus bus) {
        return busService.createBus(bus);
    }


}
