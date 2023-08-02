package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		// METODOS HIGH ORDER
		//1.-RECIBE UNA FUNCION, 2.-INTERFAZ FUNCIONA, 3.-IMPLEMENTACION DE INTERFAZ FUNCIONAL
		
		IPersonaSupplier<String> pSupplier = new PersonaSupplierImpl();
	

		MetodosHighOrder highOrder = new MetodosHighOrder();

		//CLASE
		//highOrder.metodo(pSupplier); // Puedo mandarle una clase, lambda, o metodo referenciado
		MetodosHighOrder.metodo(pSupplier);

		
		//LAMBDA
		//highOrder.metodo(() -> "5555888HO");
		MetodosHighOrder.metodo(() -> "5555888HO");
		
		//METODOS REFERENCIADOS
		//highOrder.metodo(MetodosReferenciados::getIdHO);
		MetodosHighOrder.metodo(MetodosReferenciados::getIdHO); 

		
		// *************************************************************************************
	
		//CLASE
		IPersonaConsumer<String> pConsummer = new PersonaConsumerImpl();
		//highOrder.metodoConsummer(pConsummer, "test Clase");
		MetodosHighOrder.metodoConsummer(pConsummer, "test Clase");
		
		//LAMBDA
		//highOrder.metodoConsummer(cadena -> LOG.info("HO -Lambda"), "test Lambda");
		MetodosHighOrder.metodoConsummer(cadena -> LOG.info("HO -Lambda"+cadena), " test Lambda");
		
		//METODOS REFERENCIADOS
		//highOrder.metodoConsummer(MetodosReferenciados::aceptar, "test Referenciados");
		MetodosHighOrder.metodoConsummer(MetodosReferenciados::aceptar, "test Referenciados");
		
		//**************************************************************************************
		//INTERFACES FUNCIONALES JAVA
		//1.-Supplier
		//Supplier
		Stream<String> lista = Stream.generate(() -> "123456789").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));
		
		 //2.-Consummer
		 List<Integer> listaNumero = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
		 listaNumero.forEach(cadena -> LOG.info("Consummer JAVA "+cadena));
		 
		 //3.-Predicate
		 Stream<Integer>listaFinal = listaNumero.stream().filter(numero ->numero>=5);
		 listaFinal.forEach(numero -> LOG.info("Valor :"+numero));
		
		 //4.- Function
		 Stream<String>listaCambiada = listaNumero.stream().map(numero ->{
			 Integer num =10;
			 num = numero+num;
			 return "N:"+num;
		 });
		 listaCambiada.forEach(numero -> LOG.info(numero));
		 //Stream<String>listaCambiada = listaNumero.stream().filter(numero ->numero>=5).map(numero ->"N:"+numero);
		 //listaCambiada.forEach(numero -> LOG.info(numero));
		 
		 
		 //5.-Unary Operator
		 Stream<Integer>listaCambiada2 = listaNumero.stream().map(numero ->{
			 Integer num =10;
			 num = numero+num;
			 return num;
		 });
		 
		 listaCambiada2.forEach(numero -> LOG.info("U_O:"+numero));
		 

		
	}
}
