package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU3RrApplication.class);

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Join Where
		logger.info("RELACIONAMIENTO WHERE PARÁMETROS");
		List<Hotel> hotelesWhere = this.hotelService.buscarHotelJoinWhere("Doble");
		for (Hotel h : hotelesWhere) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}

		// Inner Join Lazy
		logger.info("INNER JOIN EAGER / LAZY");
		List<Hotel> hotelesEL = this.hotelService.buscarHotelInnerJoin("Doble");
		for (Hotel h : hotelesEL) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				logger.info("Habitaciones: " + ha);
			}
		}

		// Fetch Join
		logger.info("JOIN FETCH");
		List<Hotel> hotelesFetch = this.hotelService.buscarHotelJoinFetch("Doble");
		for (Hotel h : hotelesFetch) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				logger.info("Habitaciones: " + ha);
			}
		}

	}

}
