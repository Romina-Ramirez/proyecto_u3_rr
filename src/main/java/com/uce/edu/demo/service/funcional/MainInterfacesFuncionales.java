package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {
		logger.info("Impresión: " + cadena);
	}

	public static void guardar(String elementoAInsertar) {
		// Consumo del repository para insertar
	}

	public static void main(String[] args) {

		ConsumoMetodosHighOrder metodosHighOrder = new ConsumoMetodosHighOrder();

// 1. Supplier
//		Clases
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		logger.info("Supplier Clase: " + supplierClase.getNombre());

		IPersonaSupplier<String> supplierClaseTE = new PersonaSupplierTEImpl();
		logger.info("SupplierTE Clase: " + supplierClaseTE.getNombre());

// 		Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Romina2";
		logger.info("Supplier Lambda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
		logger.info("SupplierTE Lambda: " + supplierLambdaTE.getNombre());

// 		Métodos High Order
		String valorHO = metodosHighOrder.consumirSupplier(() -> "Hola mundo");
		logger.info("Supplier High Order: " + valorHO);

		String valorHO2 = metodosHighOrder.consumirSupplier(() -> {
			String valorConsultado = "1723069801";
			return valorConsultado;
		});
		logger.info("Supplier High Order2: " + valorHO2);

// 		JAVA
		logger.info("Supplier JAVA");
		Stream<String> test = Stream.generate(() -> "Romina2").limit(7);
		test.forEach(cadena -> System.out.println(cadena));

// 2. Consumer
// 		Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		logger.info("Consumer Clase");
		consumerClase.accept("Prueba");

// 		Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		logger.info("Consumer Lambda");
		consumerLambda.accept("Prueba");

// 		Métodos High Order
		logger.info("Consumer High Order");
		metodosHighOrder.consumirConsumer(valor -> System.out.println(valor), 2);

// 		JAVA
		logger.info("Consumer JAVA");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero));

// 3. Predicate
// 		Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		logger.info("Predicate Lambda: " + predicateLambda.evaluar("RAMÍREZ"));

// 		Métodos High Order
		boolean respuesta = metodosHighOrder.consumirPredicate(cadena -> cadena.contains("O"), "RAMÍREZ");
		logger.info("Predicate High Order: " + respuesta);

// 		JAVA
		logger.info("Predicate JAVA");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));

// 4. Function
// 		Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		logger.info("Function Lambda: " + functionLambda.aplicar("7"));

// 		Métodos High Order
		String valorFinalHO = metodosHighOrder.consumirFunction(valor -> {
			String retorn = valor.toString() + "A";
			return retorn;
		}, 1);
		logger.info("Function High Order: " + valorFinalHO);

// 		JAVA
		logger.info("Function JAVA");
		// Conversiones / cast Empleado -> EmpleadoDTO (Ligero)
		Stream<String> cadenaFinal = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		// Declarativa: ideas / intenciones
		cadenaFinal.forEach(valor -> imprimir(valor));

		List<String> lista1 = new ArrayList<>();
		Map<String, String> map1 = new HashMap<String, String>();

		// Imperativa: paso a paso
//		for(String valor : listaNumeros) {
//			imprimir(valor);
//		}

// 5. UnaryOperator (Function)
// 		Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat(" Ramírez");
			return valorFinal;
		};
		logger.info("Unary Lambda: " + unaryLambda.apply("Romina"));

// 		JAVA
		logger.info("Unary JAVA");
		List<String> listaCadenas = Arrays.asList("1", "2", "3", "4", "5");

	}

}
