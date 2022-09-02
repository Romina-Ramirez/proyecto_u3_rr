package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class PasteleroParalelo {

	private String nombre;
	private List<String> pasteles;

	public PasteleroParalelo(String nombre, List<String> pasteles) {
		super();
		this.nombre = nombre;
		this.pasteles = pasteles;
	}

	@Override
	public String toString() {
		return "PastelParalelo [nombre=" + nombre + ", pasteles=" + pasteles + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getPasteles() {
		return pasteles;
	}

	public void setPasteles(List<String> pasteles) {
		this.pasteles = pasteles;
	}

}
