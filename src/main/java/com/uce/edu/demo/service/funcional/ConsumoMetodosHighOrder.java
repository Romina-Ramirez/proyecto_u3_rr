package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		/* String valor = funcion.getNombre(); // Calcular / sumar / consultar base /
		 * etc Integer numero = Integer.parseInt(valor); return numero;
		 */
		return funcion.getNombre() + " - Se procesó el dato";
	}

	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}

	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}

	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}
	
	// Deber
	public String consumirSupplierLibro(ILibroSupplier<String> funcion) {
		String editorial = "Salamanca";
		return funcion.getTitulo() + " - " + editorial;
	}
	
	public void consumirConsumerLibro(ILibroConsumer<String> funcion, String autor) {
		funcion.imprimirAutor(autor);
	}
	
	public boolean consumirPredicateLibro(ILibroPredicate<String> funcion, String autor) {
		return funcion.verificarAutor(autor);
	}
	
	public Long consumirFunctionLibro(ILibroFunction<Long, String> funcion, String titulo) {
		return funcion.contarLetras(titulo);
	}
	
	public String consumirUnaryLibro(ILibroUnaryOperator<String> funcion, String num) {
		return funcion.crearCodigo(num);
	}

}
