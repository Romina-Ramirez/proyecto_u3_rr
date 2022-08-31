package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {

	private CajeroParalelo cajero;

	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero = cajero;
	}

	// Disparar el método paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}

	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre Hilo Procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajero.getNombre());
		for (String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long Tiempo = (tiempoFinal - tiempoInicial) / 1000;
		
		System.out.println("Terminó: " + cajero.getNombre() + " en: " + Tiempo + " seg.");
	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		// Demorar el hilo 5 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
