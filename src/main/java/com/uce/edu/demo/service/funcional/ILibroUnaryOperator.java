package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface ILibroUnaryOperator<T> {
	
	public T crearCodigo(T arg1);

}
