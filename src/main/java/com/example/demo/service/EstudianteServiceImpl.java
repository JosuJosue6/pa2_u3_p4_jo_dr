package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void agregar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarPorCedula(cedula);
	}

}
