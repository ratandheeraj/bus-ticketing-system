package com.project.busticketingsystem.repository;

import com.project.busticketingsystem.model.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
}
