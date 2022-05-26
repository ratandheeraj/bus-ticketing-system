package com.project.busticketingsystem.repository;
import com.project.busticketingsystem.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
