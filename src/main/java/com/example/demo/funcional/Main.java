package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		IPersona iPersona = new PersonaImpl();
		iPersona.caminar();
		
		//1.- Supplier
		//Clases:
		IPersonaSupplier<String> personaSupplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+personaSupplier1.getId());
		
		//Lambdas***********************************/****************/****************** 
		IPersonaSupplier<String> personaSupplier2 = () ->  "17171717";
		LOG.info("Supplier Lambda: "+personaSupplier2.getId());
		
		IPersonaSupplier<String> personaSupplier3 = () ->  {String cedula = "1720525516";
															cedula = cedula +"zzzz";
															return cedula;};
		LOG.info("Supplier Lambda 2: "+personaSupplier3.getId());
	}
}
