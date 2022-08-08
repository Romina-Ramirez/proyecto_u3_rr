package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU3RrApplication.class);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Join Where
		List<Factura> facturasWhere = this.facturaService.buscarFacturaJoinWhere(1);
		logger.info("RELACIONAMIENTO WHERE");
		for (Factura f : facturasWhere) {
			logger.info("Factura: " + f.getNumero() + " " + f.getFecha());
		}

		// Inner Join Lazy
		List<Factura> facturasLazy = this.facturaService.buscarFacturaInnerJoinLazy(1);
		logger.info("INNER JOIN LAZY");
		for (Factura f : facturasLazy) {
			logger.info("Factura: " + f.getNumero() + " " + f.getFecha());
			for (Detalle d : f.getDetalles()) {
				logger.info("Detalles: " + d);
			}
		}

		// Fetch Join
		List<Factura> facturasFetch = this.facturaService.buscarFacturaJoinFetch(1);
		logger.info("JOIN FETCH");
		for (Factura f : facturasFetch) {
			logger.info("Factura: " + f.getNumero() + " " + f.getFecha());
			for (Detalle d : f.getDetalles()) {
				logger.info("Detalles: " + d);
			}
		}

	}

}
