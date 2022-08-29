package com.uce.edu.demo.service.funcional;

public class LibroPredicateImpl implements ILibroPredicate<String> {

	@Override
	public boolean verificarAutor(String arg1) {
		String autor = "Rick Yancey";
		return arg1.equals(autor);
	}

}
