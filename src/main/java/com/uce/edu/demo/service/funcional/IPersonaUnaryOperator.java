package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {

	public T apply(T arg1);

}
