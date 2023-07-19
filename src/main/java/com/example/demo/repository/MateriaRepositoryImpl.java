package com.example.demo.repository;


import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements MateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo",Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

}
