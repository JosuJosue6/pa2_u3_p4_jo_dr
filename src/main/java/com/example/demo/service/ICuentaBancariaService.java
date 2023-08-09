package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	public void agregar(CuentaBancaria bancaria);
	
	public String agregar2(CuentaBancaria bancaria);
	
	public void actualizar(CuentaBancaria bancaria);
	
	public CuentaBancaria buscarPorNumero(String numero);
	
	public void borrarPorNumero(String numero);
	
	public void agregarAsincrono(CuentaBancaria bancaria);
	
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria bancaria);
	
}
