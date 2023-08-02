package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder { //METODO QEU RECIBE UNA INTERFAZ FUNCIONES /PRACTICA UNA IMPLEMENTACION

	private static final Logger LOG = LoggerFactory.getLogger(MetodosHighOrder.class);

	public static void metodo(IPersonaSupplier<String> funcion) { //En este metodo recibe una interfaz como argumento
		
		LOG.info("High Order Suplier "+funcion.getId());
		
	}
	
	public static void metodoConsummer(IPersonaConsumer<String> funcion, String t) {
		
		//String test = "Ejemplo";
		LOG.info("HO Consummer");
		funcion.accept(t);
	}
}
