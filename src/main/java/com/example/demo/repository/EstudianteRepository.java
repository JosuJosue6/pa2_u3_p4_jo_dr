package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	
	public Estudiante buscarPorCedula(String cedula);
}
