package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		Cajero cajero1 = new Cajero("Romina", Arrays.asList("Pepito", "Juan"));
		Cajero cajero2 = new Cajero("Marta", Arrays.asList("Andres", "Juana"));
		Cajero cajero3 = new Cajero("Julia", Arrays.asList("Lucas", "Hanna"));

		// Romina
		PCCajero gestorAtencion1 = new PCCajero();
		gestorAtencion1.procesar(cajero1);

		// Marta
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion2.procesar(cajero2);

		// Julia
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);

		long tiempoFinal = System.currentTimeMillis();

		long Tiempo = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(Tiempo + " seg");

	}

}
