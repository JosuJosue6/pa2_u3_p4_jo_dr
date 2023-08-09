package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4JoDrApplication implements CommandLineRunner {

	// Como es una constante siempre esta al inicio
	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4JoDrApplication.class);

	@Autowired
	private ICuentaBancariaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Multihilo usando agregar 2 y Function
		// ***********************************************************************************
		// Inicio
		// Dependende de la cantidad de datos a trabajar
		// Para saber la cantidad de hilos a usar.

		// Asincrono sin respuesta

		/*
		 * long tiempoInicial = System.currentTimeMillis();
		 * 
		 * List<CuentaBancaria> lista = new ArrayList<>(); for(int i = 1 ; i<= 10 ; i++)
		 * { CuentaBancaria ctaOrigen = new CuentaBancaria();
		 * ctaOrigen.setNumero(String.valueOf(i)); ctaOrigen.setTipo("Corriente");
		 * ctaOrigen.setSaldo(new BigDecimal(100)); lista.add(ctaOrigen);
		 * this.bancariaService.agregarAsincrono(ctaOrigen); }
		 * 
		 * 
		 * //fin long tiempoFinal = System.currentTimeMillis(); long tiempoTranscurrido
		 * = (tiempoFinal - tiempoInicial)/1000;
		 * LOG.info("Tiempo transcurrido: "+(tiempoFinal - tiempoInicial));
		 * LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		 * LOG.info("Se termino de procesar todo :) ");
		 */

		// Asincrono futuro con respuesta ********************************
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuesta = new ArrayList<>();
		List<CuentaBancaria> lista = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setTipo("Corriente");
			
			ctaOrigen.setSaldo(new BigDecimal(100));
			lista.add(ctaOrigen);
			CompletableFuture<String> respuesta = this.bancariaService.agregarAsincrono2(ctaOrigen);
			listaRespuesta.add(respuesta);
		}
 
		//sentencia que esepra que terine de Procesarse todos los hilos para obtener la RESPUESTA.
		CompletableFuture.allOf(listaRespuesta.get(0), listaRespuesta.get(1), listaRespuesta.get(2),
				listaRespuesta.get(3), listaRespuesta.get(4), listaRespuesta.get(5), listaRespuesta.get(5),
				listaRespuesta.get(6), listaRespuesta.get(7), listaRespuesta.get(8), listaRespuesta.get(9));

		LOG.info("Respuesta 0: " + listaRespuesta.get(0).get());
		
		// fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		LOG.info("Se termino de procesar todo :) ");
	}

}
