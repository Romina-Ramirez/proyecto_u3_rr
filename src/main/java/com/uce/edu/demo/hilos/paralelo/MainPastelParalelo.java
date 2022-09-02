package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainPastelParalelo {
	
	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		
		PasteleroParalelo pastelero1 = new PasteleroParalelo("Romina", Arrays.asList("Chocolate con menta", "Vainilla y chocolate"));
		PasteleroParalelo pastelero2 = new PasteleroParalelo("Marta", Arrays.asList("Pistacho", "Mora y fresa"));
		PasteleroParalelo pastelero3 = new PasteleroParalelo("Julia", Arrays.asList("Cheesecake", "Tiramisu"));
		PasteleroParalelo pastelero4 = new PasteleroParalelo("Luis", Arrays.asList("Pie de manzana", "Ron pasas"));
		PasteleroParalelo pastelero5 = new PasteleroParalelo("Andres", Arrays.asList("Durazno", "Frutos rojos"));
		
		HornoParalelo gestorAtencion1 = new HornoParalelo(pastelero1);
		gestorAtencion1.start();
		
		HornoParalelo gestorAtencion2 = new HornoParalelo(pastelero2);
		gestorAtencion2.start();
		
		HornoParalelo gestorAtencion3 = new HornoParalelo(pastelero3);
		gestorAtencion3.start();
		
		HornoParalelo gestorAtencion4 = new HornoParalelo(pastelero4);
		gestorAtencion4.start();
		
		HornoParalelo gestorAtencion5 = new HornoParalelo(pastelero5);
		gestorAtencion5.start();
		
		long tiempoFinal = System.currentTimeMillis();

		long Tiempo = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(Tiempo + " seg");
	}
	
}
