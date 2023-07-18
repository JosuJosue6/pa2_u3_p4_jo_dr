package com.example.demo.universidad.repository;

import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.repository.modelo.Matricula;

public interface MatriculaRepository {
	
	public void insertar(Matricula matricula);

	public void actualizar(Matricula matricula);

	public void eliminarPorNumero(String numero);

	public Matricula seleccionarporNumero(String numero);

}
