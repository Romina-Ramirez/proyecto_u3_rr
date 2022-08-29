package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class LibroConsumerImpl implements ILibroConsumer<String>{
	
	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionalesLibros.class);

	@Override
	public void imprimirAutor(String arg1) {
		logger.info("Consumer Clase: " + arg1);
	}

}
