package com.example.demo.repository;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public void insertar(CuentaBancaria bancaria);
	
	public void actualizar(CuentaBancaria bancaria);
	
	public CuentaBancaria seleccionarPorNumero(String numero);
	
	public void eliminarPorNumero(String numero);
}
