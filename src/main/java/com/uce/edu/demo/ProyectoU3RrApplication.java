package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3RrApplication implements CommandLineRunner{
	
	private static final Logger logger = Logger.getLogger(ProyectoU3RrApplication.class);
	
	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Inner
		logger.info("INNER JOIN PARÁMETROS");
		List<Hotel> hoteles = this.hotelService.buscarHotelInnerJoin("Doble");
		for(Hotel h : hoteles) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		logger.info("INNER JOIN");
		List<Hotel> hoteles1 = this.hotelService.buscarHotelInnerJoin();
		for(Hotel h : hoteles1) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		// Left
		logger.info("LEFT JOIN PARÁMETROS");
		List<Hotel> hotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Doble");
		for(Hotel h : hotelesLeft) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		logger.info("LEFT JOIN ");
		List<Hotel> hotelesLeft1 = this.hotelService.buscarHotelOuterJoinLeft();
		for(Hotel h : hotelesLeft1) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		// Right
		logger.info("RIGHT JOIN");
		List<Hotel> hotelesRight = this.hotelService.buscarHotelOuterJoinRight("Doble");
		for(Hotel h : hotelesRight) {
			logger.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}

	}

}
