package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
		
	@Override
	public void agregar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(bancaria);
	}

	@Override
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

}
