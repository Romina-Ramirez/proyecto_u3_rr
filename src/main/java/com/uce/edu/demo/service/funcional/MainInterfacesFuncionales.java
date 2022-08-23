package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static final Logger logger = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

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
		
// 		JAVA

// 2. Consumer
// 		Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer Clase");

// 		Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

// 3. Predicate
// 		Clases
// 		Lambdas

// 4. Function
// 		Clases
// 		Lambdas

// 5. UnaryOperator (Function)
// 		Clases
// 		Lambdas

	}

}
