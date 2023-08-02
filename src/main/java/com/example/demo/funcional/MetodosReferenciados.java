package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MetodosReferenciados {
	
	private static final Logger LOG = LoggerFactory.getLogger(MetodosReferenciados.class);

	//Supplier
	public static Integer getId() {

		return 8;
	}
	
	//Supplier
		public static String getIdHO() {

			LOG.info("Metodos Referenciados y HO");
			return "Equipo 7";
		}

	//Consumer
	public static void aceptar(String arg) {

		String cadena = "Equipo";
		LOG.info(cadena+ " "+ arg);

	}

	//Predicate
	public static boolean evaluacion(Integer arg) {
		Integer numero =10;
		boolean cumple = false;

		if (numero.compareTo(arg)==0) {

			cumple = true;
		}

		return cumple;
	}

	//FUNCTION
	public static String aplicar(Integer arg) {

		return arg.toString().concat(" cambio a string");
	}

	//UNARY OPERATOR
	public static Integer aplicarUO(Integer arg) {
		return arg * 100;
	}
}
