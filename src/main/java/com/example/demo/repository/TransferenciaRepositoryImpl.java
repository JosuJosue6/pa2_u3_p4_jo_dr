package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(transferencia);
	}

	@Override
	public Transferencia seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	public void eliminarPorID(Integer id) {
		// TODO Auto-generated method stub
		Transferencia transferencia = this.seleccionarPorID(id);
		this.entityManager.remove(transferencia);
	}

	@Override
	public List<Transferencia> seleccionarTransferenciasPorNumeroCuenta(String numeroCuenta) {
		// TODO Auto-generated method stub
		TypedQuery<Transferencia> myQuery = this.entityManager
				.createQuery("SELECT t from Transferencia t WHERE t.cuentaOrigen.numero = :datoCuenta", Transferencia.class);
		myQuery.setParameter("datoCuenta", numeroCuenta);
		return myQuery.getResultList();
	}

}
