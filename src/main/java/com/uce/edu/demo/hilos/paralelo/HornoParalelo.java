package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class HornoParalelo extends Thread {

	private PasteleroParalelo pastelero;

	public HornoParalelo(PasteleroParalelo pastelero) {
		this.pastelero = pastelero;
	}

	@Override
	public void run() {
		this.hornear(this.pastelero);
	}

	public void hornear(PasteleroParalelo pastelero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName());
		System.out.println("Está horneando el pastelero: " +pastelero.getNombre());
		for(String pastel : pastelero.getPasteles()) {
			this.hornearPastel(pastel);
		}
		long tiempoFinal = System.currentTimeMillis();
		long Tiempo = (tiempoFinal - tiempoInicial) / 1000;
		
		System.out.println("Terminó: " + pastelero.getNombre() + " en: " + Tiempo + " seg.");
	}

	private void hornearPastel(String pastel) {
		System.out.println("Hornear el: " + pastel);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
