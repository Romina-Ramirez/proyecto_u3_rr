package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU3RrApplication.class);

	@Autowired
	private ITransferenciaService transferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.transferenciaService.realizarTransferencia("1245", "1246", new BigDecimal(8));

	}

}
