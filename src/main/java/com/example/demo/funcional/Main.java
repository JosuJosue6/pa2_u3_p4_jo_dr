package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		IPersona iPersona = new PersonaImpl();
		iPersona.caminar();

		// 1.- Supplier
		// Clases:
		IPersonaSupplier<String> personaSupplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + personaSupplier1.getId());

		// Lambdas***********************************/****************/******************
		IPersonaSupplier<String> personaSupplier2 = () -> "17171717";
		LOG.info("Supplier Lambda: " + personaSupplier2.getId());

		IPersonaSupplier<String> personaSupplier3 = () -> {
			String cedula = "1720525516";
			cedula = cedula + "zzzz";
			return cedula;
		};
		LOG.info("Supplier Lambda 2: " + personaSupplier3.getId());
		
		/*
		 * METODOS REFERENCIADOS 
		 * se lo hace mediante "::"
		 */
		MetodosReferenciados metodos = new MetodosReferenciados();
		IPersonaSupplier<Integer> personaSupplier4 = metodos::getId;
		LOG.info("Supplier(Metd Referenciado): " + personaSupplier4.getId());

		// 2 consumer
		// CLASES
		IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();
		LOG.info("Consummer Clase: ");
		consumer1.accept("Diego Rivas");

		// Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOG.info("1");
			LOG.info("--2");
			LOG.info("---3");

		};

		LOG.info("Consummer Lambda: ");
		consumer2.accept("Jouse Ocapana");
		
		/*
		 * METODOS REFERENCIADOS EN CONSUMER
		 * se lo hace mediante "::"
		 */
		IPersonaConsumer<String> cunsumer3 = metodos::aceptar;
		LOG.info("Consummer (Metodos Referenciados): ");
		cunsumer3.accept(" gg");

		// 3.- PREDICATE
		// Argumento --> Return Boolean
		// Lambdas
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOG.info("PREDICATE Lambda: " + predicate1.evaluar(47));// false

		// ejemplo 2
		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) >= 0) {
				return true;
			} else {
				return false;
			}

		};
		LOG.info("PREDICATE EJEM 2 Lambda: " + predicate2.evaluar(95));// true

		// Ejemplo Ver si mi nombre tiene mi caracter
		String name = "TestA";
		IPersonaPredicate<String> predicate3 = valor -> name.contains(valor);

		LOG.info("PREDICATE  Name : " + predicate3.evaluar("A"));// true

		// Ejemplo dos parametros
	
		//Funcion qeu recibe 2 valores --> BIPREDICATE
		//Bi funcion,---- a todos exceptro al UNARY Y CONSUMER
		IPersonaBiPredicate<String, String> predicate4 = (name2, letra) -> name2.contains(letra);

		LOG.info("PREDICATE  Lambda BiPredicate : " + predicate4.evaluar("Test", "t"));// true
		
		
		/*
		 * METODOS REFERENCIADOS EN PREDICATE
		 * se lo hace mediante "::"
		 */
		IPersonaPredicate<Integer> predicate5 = metodos::evaluacion;
		LOG.info("PREDICATE (Metods Referenciados): " + predicate5.evaluar(10));// true
		
		
		//----------------------------
		//4.- Function   --> Recibe un argumento y devuelve otro tipo
		//Para funciones de casteo
		//UNO ES EL DATO QEU RECIBE (integer) Y EL OTRO ES EL RETORNO
		IPersonaFunction<String, Integer> function = numero -> numero.toString();
		LOG.info("FUNCTION  lambda ejem : " + function.aplicar(8));
		
		
		//ejemplo 2 con Function
		IPersonaFunction<String, Integer> function1 = numero ->{
			String valorF = numero.toString().concat("_Capo");
			 return valorF;
		};
		LOG.info("FUNCTION lambda ejem1 : " + function1.aplicar(10));
		
		
		/*
		 * METODOS REFERENCIADOS EN FUNCTION
		 * se lo hace mediante "::"
		 */
		
		
		
		
		//-------------------------
		//UNARY OPERATOR
		//Lo que recibe es el mismo retorno en el tipo de dato
		IPersonaUnaryOperator<Integer> unary = numero -> numero+(numero*2);
		LOG.info("UNARY  OPERATOR lambda: " + unary.aplicar(10));
		
		
		//Ejemplo de manera de Herencia de Function
		IPersonaUnaryOperatorFunction<Integer> unary1 =numero -> numero +(numero-5);
		LOG.info("UNARY  DERIVADA lambda: " + unary1.aplicar(25));
		
		
		
		//TERCER TIPO DE IMLEMENTACION HIGH ORDER(SIRVEN PARA ESPECIFICAR UN TIPO DE FUNCIONALIDAD ADICIONAL9
		//Tambien se lo conoce como METODS REFERENCIADOS
		/*
		 * Mientras se cumpla el contrato,
		 * yo le puedo pasar como una implementacion de la interfaz funcional
		 * 
		 */
		
		

	}
}
