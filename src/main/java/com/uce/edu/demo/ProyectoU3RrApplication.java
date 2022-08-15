package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU3RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU3RrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
