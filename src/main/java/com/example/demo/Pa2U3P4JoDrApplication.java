package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;
import com.example.demo.service.MateriaService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U3P4JoDrApplication implements CommandLineRunner{
	
	//Como es una constante siempre esta al inicio
	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4JoDrApplication.class);


	@Autowired
	private ICuentaBancariaService bancariaService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	Manejo de un hilo ****************************************************************************************************************************************
	 * //Imprime el nombre del hilo con el que se ejecuta mi programa
		LOG.info("Hilo: "+Thread.currentThread().getName());
	
		//Medir el tiempo de una linea de cofigo
		//Hilo esta relacionada con el recurso diusponible ( procesador) 
		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		for(int i = 1 ; i<= 30 ; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setTipo("Ahorro");
			ctaOrigen.setSaldo(new BigDecimal(100));
			
			this.bancariaService.agregar(ctaOrigen);
		}
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		*/
		
		//MultiHilo************************************************************************************************************************************************
		/*
		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		
		List<CuentaBancaria> lista = new ArrayList<>();
		for(int i = 1 ; i<= 100 ; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setTipo("Corriente");
			ctaOrigen.setSaldo(new BigDecimal(100));
			lista.add(ctaOrigen);
		}
		//usamos for each pues usa un consumer que toma un parametro y no retorna nada 
		//al igual que el metodo agregar
		//lista.stream().forEach(cta->this.bancariaService.agregar(cta));
		//Programacion en paralelo
		lista.parallelStream().forEach(cta->this.bancariaService.agregar(cta));
		
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
	*/
	
		//Multihilo usando agregar 2 y Function ***********************************************************************************
		//Inicio
		long tiempoInicial = System.currentTimeMillis();
		
		List<CuentaBancaria> lista = new ArrayList<>();
		for(int i = 1 ; i<= 100 ; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setTipo("Corriente");
			ctaOrigen.setSaldo(new BigDecimal(100));
			lista.add(ctaOrigen);
		}

		/*lista.parallelStream().forEach(cta->LOG.info("Se inserto el numero de cuenta: "
				+ ""+this.bancariaService.agregar2(cta)));*/
		
		Stream<String> listaFinal = lista.parallelStream().map(cta->this.bancariaService.agregar2(cta));
		LOG.info("Se guardaron las siguientes cuentas");
		listaFinal.forEach(cadena -> LOG.info(cadena));
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
	}

}
