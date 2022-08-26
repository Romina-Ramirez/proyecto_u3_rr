package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.IClienteService;
import com.uce.edu.demo.service.IGestorCompraService;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class ProyectoU3RrApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(ProyectoU3RrApplication.class);

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IGestorCompraService compraService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3RrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Producto p = new Producto();
		p.setCodigoBarras("PDA001");
		p.setInventario(10);
		p.setNombre("Savital");
		p.setPrecio(new BigDecimal(3.75));

		// this.productoService.insertar(p);

		Cliente c = new Cliente();
		c.setCedula("1723069801");
		c.setNombre("Romina");
		c.setApellido("Ramírez");
		c.setNumeroTarjeta("1236547852");

		// this.clienteService.insertar(c);

		List<String> lista = new ArrayList<>();
		lista.add("PDA001");
		lista.add("LAC001");

		this.compraService.realizarCompra("1723069801", "00004", lista);

	}

}
