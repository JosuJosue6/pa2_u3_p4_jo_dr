package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula",Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
