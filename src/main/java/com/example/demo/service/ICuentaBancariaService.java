package com.example.demo.service;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	public void agregar(CuentaBancaria bancaria);
	
	public void actualizar(CuentaBancaria bancaria);
	
	public CuentaBancaria buscarPorNumero(String numero);
	
	public void borrarPorNumero(String numero);
	
}
