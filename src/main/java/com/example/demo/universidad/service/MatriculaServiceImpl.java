package com.example.demo.universidad.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.universidad.repository.EstudianteRepository;
import com.example.demo.universidad.repository.MatriculaRepository;
import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.repository.modelo.Materia;
import com.example.demo.universidad.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;


	@Override
	public void matricular(String cedulaEstudiante, Materia codigosMateria) {
		// TODO Auto-generated method stub
		Estudiante estu = this.estudianteRepository.seleccionarPorCedula(cedulaEstudiante);
		Matricula matricula1 = new Matricula();
		matricula1.setCredito("4");
		matricula1.setEstudiante(estu);
		matricula1.setFecha(LocalDateTime.now());
		matricula1.setNumero("55");
		matricula1.setMateria(codigosMateria);
		
		this.matriculaRepository.insertar(matricula1);
	}

}
