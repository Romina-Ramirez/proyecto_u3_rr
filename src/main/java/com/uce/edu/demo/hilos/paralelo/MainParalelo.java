package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());

		CajeroParalelo cajero1 = new CajeroParalelo("Romina", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Marta", Arrays.asList("Andres"));
		CajeroParalelo cajero3 = new CajeroParalelo("Julia", Arrays.asList("Lucas"));
		
		CajeroParalelo cajero4 = new CajeroParalelo("Romina2", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("Marta2", Arrays.asList("Juana"));
		CajeroParalelo cajero6 = new CajeroParalelo("Julia2", Arrays.asList("Hanna"));

		// Romina
		PCCajeroParalelo gestorAtencion1 = new PCCajeroParalelo(cajero1);
		gestorAtencion1.start(); // procesar

		// Marta
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start(); // procesar

		// Julia
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start(); // procesar
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start(); // procesar

		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start(); // procesar

		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start(); // procesar

		long tiempoFinal = System.currentTimeMillis();

		long Tiempo = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(Tiempo + " seg");
	}

}
