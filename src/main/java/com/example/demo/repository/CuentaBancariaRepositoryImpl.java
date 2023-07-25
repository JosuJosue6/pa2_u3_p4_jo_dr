package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bancaria);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bancaria);
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT cb FROM CuentaBancaria cb WHERE cb.numero = :datoNumero", CuentaBancaria.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	public void eliminarPorNumero(String numero) {
		// TODO Auto-generated method stub
		CuentaBancaria bancaria = this.seleccionarPorNumero(numero);
		this.entityManager.remove(bancaria);
	}

}
