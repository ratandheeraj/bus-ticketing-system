package com.project.busticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BusTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketingSystemApplication.class, args);
	}

}
