package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long tiempoInicial = System.currentTimeMillis();

		Cajero cajero1 = new Cajero("Romina", Arrays.asList("Pepito", "Juan", "Daniel", "Pedro", "Luis", "Maria"));
		Cajero cajero2 = new Cajero("Marta", Arrays.asList("Andres", "Juana", "Daniela", "Lucia"));
		Cajero cajero3 = new Cajero("Julia", Arrays.asList("Lucas", "Hanna", "Aria", "Spencer", "Caleb"));

		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);

		long tiempoFinal = System.currentTimeMillis();

		long Tiempo = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(Tiempo + " seg");

	}

}
