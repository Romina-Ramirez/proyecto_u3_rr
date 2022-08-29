package com.uce.edu.demo.service.funcional;

public class LibroUnaryOperatorImpl implements ILibroUnaryOperator<String> {

	@Override
	public String crearCodigo(String arg1) {
		String genero = "FICCION";
		String codigo = genero.concat(arg1);
		return codigo;
	}

}
