package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository propietarioRepository;

	@Autowired
	private IPruebaService iPruebaService;

	@Override
	//@Transactional
	public void agregar(Propietario propietario) {
		// TODO Auto-generated method stub
		System.out.println("Service "+TransactionSynchronizationManager.isActualTransactionActive());
		//this.propietarioRepository.insertar(propietario);
		//this.prueba();
		//this.iPruebaService.prueba();
		//this.iPruebaService.prueba2();
		//this.iPruebaService.pruebaSuports();
		//this.iPruebaService.pruebaNotSupported();
		//this.iPruebaService.pruebaRequired();
		this.iPruebaService.pruebaRequiresNew();
	}
	/*@Override
	public void agregar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.insertar(propietario);
	}*/

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	public Propietario buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.propietarioRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void borrarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		this.propietarioRepository.eliminarPorCedula(cedula);
	}
	
}
