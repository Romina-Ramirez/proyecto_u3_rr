package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionalesLibros {

	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionalesLibros.class);

	public static void main(String[] args) {
		
		ConsumoMetodosHighOrder metodos = new ConsumoMetodosHighOrder();

		String titulo = "Orgullo y Prejuicio";
		String titulo2 = "La Quinta Ola";
		String titulo3 = "Bridgerton";
		String autor = "Jane Austen";
		String autor2 = "Rick Yancey";
		String autor3 = "Julia Quinn";
		String genero = "ROMANCE";

// 1. Supplier
//		Clases		
		ILibroSupplier<String> supplierClase = new LibroSupplierImpl();
		logger.info("Supplier Clase: " + supplierClase.getTitulo());
		
// 		Lambdas
		ILibroSupplier<String> supplierLambda = () -> titulo;
		logger.info("Supplier Lambda: " + supplierLambda.getTitulo());

// 		Métodos High Order
		String valorHO = metodos.consumirSupplierLibro(() -> titulo3);
		logger.info("Supplier High Order: " + valorHO);
		
		System.out.println();

// 2. Consumer
//		Clases
		ILibroConsumer<String> consumerClase = new LibroConsumerImpl();
		consumerClase.imprimirAutor(autor2);
		
// 		Lambdas
		ILibroConsumer<String> consumerLambda = cadena -> logger.info("Consumer Lambda: " + cadena);
		consumerLambda.imprimirAutor(autor);

// 		Métodos High Order
		metodos.consumirConsumerLibro(cadena -> logger.info("Consumer High Order: " + cadena), autor3);
		
		System.out.println();

// 3. Predicate
//		Clases
		ILibroPredicate<String> predicateClase = new LibroPredicateImpl();
		logger.info("Predicate Clase: " + predicateClase.verificarAutor(autor2));
		
// 		Lambdas
		ILibroPredicate<String> predicateLambda = cadena -> cadena.equals("Jann Austen");
		logger.info("Predicate Lambda: " + predicateLambda.verificarAutor(autor));

// 		Métodos High Order
		boolean res = metodos.consumirPredicateLibro(cadena -> cadena.equals("Julia Quin"), autor3);
		logger.info("Predicate High Order: " + res);
		
		System.out.println();

// 4. Function
//		Clases
		ILibroFunction<Long, String> functionClase = new LibroFunctionImpl();
		logger.info("Function Clase: " + functionClase.contarLetras(titulo2));
		
// 		Lambdas
		ILibroFunction<Long, String> functionLambda = cadena -> cadena.chars().count();
		logger.info("Function Lambda: " + functionLambda.contarLetras(titulo));

// 		Métodos High Order
		Long valHO = metodos.consumirFunctionLibro(cadena -> cadena.chars().count(), titulo3);
		logger.info("Function High Order: " + valHO);
		
		System.out.println();

// 5. UnaryOperator (Function)
//		Clases
		ILibroUnaryOperator<String> unaryClase = new LibroUnaryOperatorImpl();
		logger.info("Unary Clases: " + unaryClase.crearCodigo("001"));
		
// 		Lambdas
		ILibroUnaryOperator<String> unaryLambda = cadena -> {
			String codigo = genero.concat(cadena);
			return codigo;
		};
		logger.info("Unary Lambda: " + unaryLambda.crearCodigo("002"));
		
// 		Métodos High Order
		String codigoFinal = metodos.consumirUnaryLibro(cadena -> {
			String codigo = genero.concat(cadena);
			return codigo;
		}, "003");
		logger.info("Unary High Order: " + codigoFinal);

	}

}
