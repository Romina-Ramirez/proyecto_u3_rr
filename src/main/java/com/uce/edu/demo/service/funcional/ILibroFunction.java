package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface ILibroFunction<R,T> {
	
	public R contarLetras(T arg1);

}
