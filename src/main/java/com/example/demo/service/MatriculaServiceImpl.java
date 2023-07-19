package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Override
	public void matricular(String cedula, List<String> codigosMaterias) {
		// TODO Auto-generated method stub
		Estudiante estudiante = this.estudianteRepository.buscarPorCedula(cedula);
		List<Matricula>matriculas = new ArrayList<>();
		int i =1;
		for (String codigo : codigosMaterias) {
			Materia materia = this.materiaRepository.seleccionarPorCodigo(codigo);
			Matricula matricula = new Matricula();
			matricula.setCodigosMateria(codigosMaterias);
			matricula.setEstado("matriculado");
			matricula.setFecha(LocalDate.now());
			matricula.setMateria(materia);
			matricula.setEstudiante(estudiante);
			matricula.setNumero(""+i);
			matriculas.add(matricula);
			i++;
			this.matriculaRepository.insertar(matricula);
		}
		estudiante.setMatriculas(matriculas);
		
		

	}

}
