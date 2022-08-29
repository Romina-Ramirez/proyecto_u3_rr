package com.uce.edu.demo.service.funcional;

public class LibroFunctionImpl implements ILibroFunction<Long, String>{

	@Override
	public Long contarLetras(String arg1) {
		Long cont = arg1.chars().count();
		return cont;
	}

}
