package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.Pa2U3P4JoDrApplication;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
		
	@Override
	public void agregar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		LOG.info("Hilo Service:  "+Thread.currentThread().getName());
		//Sumar, restar, multiplicar, consultar en la base en si logica que demora un segundo
		//controla el tiempo que se demora
		try {
			TimeUnit.SECONDS.sleep(1);

			this.bancariaRepository.insertar(bancaria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String agregar2(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		LOG.info("Hilo Service:  "+Thread.currentThread().getName());
		//Sumar, restar, multiplicar, consultar en la base en si logica que demora un segundo
		//controla el tiempo que se demora
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(bancaria);
		return bancaria.getNumero();
	}

	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(bancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorNumero(numero);
	}

	@Override
	public void borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminarPorNumero(numero);
	}

	@Override
	@Async
	public void agregarAsincrono(CuentaBancaria bancaria) {

		LOG.info("Hilo Service Asincrono :  "+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(bancaria);

	}

	@Override
	@Async
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria bancaria) {
		LOG.info("Hilo Service Asincrono :  "+Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(bancaria);
		
		return CompletableFuture.completedFuture(bancaria.getNumero());
	}


}
