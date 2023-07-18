package com.example.demo.universidad.service;

import java.util.List;

import com.example.demo.universidad.repository.modelo.Materia;
import com.example.demo.universidad.repository.modelo.Matricula;

public interface MatriculaService {
	

	public void matricular(String cedulaEstudiante,Materia codigosMateria);
}
