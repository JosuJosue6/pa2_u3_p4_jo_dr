package com.example.demo.universidad.repository;

import com.example.demo.universidad.repository.modelo.Estudiante;

public interface EstudianteRepository {
	
	
	public void insertar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(String cedula);

	public Estudiante seleccionarPorCedula(String cedula);

}
