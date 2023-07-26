package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

	/*
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setNumero("111");
		ctaOrigen.setTipo("A");
		ctaOrigen.setSaldo(new BigDecimal(100));
		
		this.bancariaService.agregar(ctaOrigen);
		

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setNumero("222");
		ctaDestino.setTipo("A");
		ctaDestino.setSaldo(new BigDecimal(200));
		
		this.bancariaService.agregar(ctaDestino);
		*/
		this.iTransferenciaService.realizarTransferencia("111", "222", new BigDecimal(10));
		
	}

}
