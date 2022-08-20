package com.uce.edu.demo.repository.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;

//Busca el Spring Boot Application para configurarse
@SpringBootTest
class CuentaBancariaTest {

	private static final Logger logger = Logger.getLogger(CuentaBancariaTest.class);

	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;

	// Se ejecuta una vez, antes de comenzar todos los tests. Estos métodos deben
	// definirse como static para trabajar con JUnit.
	@BeforeAll
	public static void antesClase() {
		logger.info("Inicia la prueba de test de la clase");
	}

	// Se ejecuta antes de cada test. Normalmente se utiliza para preparar el
	// entorno de testing (por ejemplo: inicialización de clases, lectura de datos
	// de entrada...)
	@BeforeEach
	public void antesMetodo() {
		logger.info("Inicia la prueba de test para el método");
	}

	// Se ejecuta una vez, cuando los tests han finalizado. Estos métodos deben
	// definirse como static para trabajar con JUnit.
	@AfterAll
	public static void despuesClase() {
		logger.info("Finaliza la prueba de test de la clase");
	}

	// Se ejecuta después de cada test. Normalmente se utiliza para limpiar el
	// entorno de testing.
	@AfterEach
	public void despuesMetodo() {
		logger.info("Finaliza la prueba de test de el método");
	}

	// La anotación @Test le dice a la JVM que el siguiente método es una prueba.
	// Esta anotación es necesaria antes de cada método de prueba.
	@Test
	public void testIngresarCuentaBancaria() {
		CuentaBancaria cuenta = new CuentaBancaria();
		cuenta.setNumero("0009");
		cuenta.setSaldo(new BigDecimal(125));
		cuenta.setTipo("Ahorros");

		// Sirve para afirmar que un tipo de dato u objeto no es nulo.
		assertNotNull(cuenta, "La cuenta está en null");

		this.cuentaBancariaRepository.crear(cuenta);
	}

	@Test
	public void testLeerPorNumero() {
		CuentaBancaria cuenta = this.cuentaBancariaRepository.leerPorNumero("0006");
		// Se aseguran de que los dos argumentos que pasamos son iguales, en caso de que
		// no lo sean, la prueba fallará.
		assertEquals(new BigDecimal(150).setScale(2), cuenta.getSaldo(), "Los datos no son iguales");
		logger.info(cuenta);
	}

	@Test
	public void testLeerCuentas() {
		List<CuentaBancaria> lista = this.cuentaBancariaRepository.leerCuentas();
		// Sirve para comparar un tipo de dato u objeto.
		assertThat(lista).size().isLessThan(10);
		logger.info(lista.size());
	}

	@Test
	public void testActualizar() {
		CuentaBancaria cuenta = this.cuentaBancariaRepository.leerPorNumero("0005");
		cuenta.setSaldo(new BigDecimal(724));

		// Se aseguran de que los dos argumentos que pasamos no son iguales, en caso de
		// que
		// lo sean, la prueba fallará.
		assertNotEquals(new BigDecimal(724).setScale(2), this.cuentaBancariaRepository.leerPorNumero("0005").getSaldo(),
				"Los datos son iguales.");

		this.cuentaBancariaRepository.actualizar(cuenta);
	}

	// El método de test debe ser desactivado (no se ejecuta).
	@Disabled
	@Test
	public void testEliminar() {
		CuentaBancaria cuenta = this.cuentaBancariaRepository.leerPorNumero("0005");
		Integer id = cuenta.getId();
		this.cuentaBancariaRepository.eliminar(id);
	}

}
