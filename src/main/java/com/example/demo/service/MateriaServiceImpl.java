package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MateriaRepository;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements MateriaService{

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Override
	public void agregar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.insertar(materia);
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarPorCodigo(codigo);
	}

}
