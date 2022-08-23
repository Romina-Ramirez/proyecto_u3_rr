package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	
	public Boolean evaluar(T arg1);

}
