package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

}
