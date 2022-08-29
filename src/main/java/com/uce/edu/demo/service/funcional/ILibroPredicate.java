package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface ILibroPredicate<T> {
	
	public boolean verificarAutor(T arg1);

}
