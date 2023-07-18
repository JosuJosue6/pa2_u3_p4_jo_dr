package com.example.demo.universidad.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.universidad.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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

	@Override
	public void actualizar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.merge(matricula);
	}

	@Override
	public void eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		Matricula matriculasEncontrada = this.seleccionarporNumero(numero);
		this.entityManager.remove(matriculasEncontrada);
		
	}

	@Override
	public Matricula seleccionarporNumero(String numero) {
		// TODO Auto-generated method stub
		// 
		TypedQuery<Matricula> myQuery = this.entityManager.createQuery("SELECT m FROM Matricula m  WHERE m.numero = :datoNumero",Matricula.class);
		myQuery.setParameter("datoNumero", numero);
		
		return myQuery.getSingleResult();
	}

}
