package com.example.demo.repository;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void insertar(Propietario propietario);
	
	public void actualizar(Propietario propietario);
	
	public Propietario seleccionarPorCedula(String cedula);
	
	public void eliminarPorCedula(String cedula);
}
