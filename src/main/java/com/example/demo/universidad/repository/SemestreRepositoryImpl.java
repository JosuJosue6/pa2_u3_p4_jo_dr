package com.example.demo.universidad.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.universidad.repository.modelo.Semestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SemestreRepositoryImpl implements SemestreRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Semestre semestre) {
		// TODO Auto-generated method stub
		this.entityManager.persist(semestre);
	}

}
