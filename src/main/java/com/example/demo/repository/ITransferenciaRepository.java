package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaRepository {


	public void insertar(Transferencia transferencia);
	
	public void actualizar(Transferencia transferencia);
	
	public Transferencia seleccionarPorID(Integer id);
	
	public void eliminarPorID(Integer id);

	public List<Transferencia> seleccionarTransferenciasPorNumeroCuenta(String numeroCuentaS);
	
}
