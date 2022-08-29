package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface ILibroConsumer<T> {
	
	public void imprimirAutor(T arg1);

}
