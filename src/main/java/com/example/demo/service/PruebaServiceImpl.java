package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PruebaServiceImpl implements IPruebaService{

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("Never"+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba NEVER");

	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		// TODO Auto-generated method stub
		System.out.println("Mandatory"+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba 2 Mandatory");	
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSuports() {
		// TODO Auto-generated method stub
		System.out.println("Support"+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba supports");
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		// TODO Auto-generated method stub
		System.out.println("Not Supoorted: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Not supporteds");
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaRequired() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Required");
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		// TODO Auto-generated method stub
		System.out.println("Metodo 2: "+TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("Metodo de prueba Required NEw");
	}

}
