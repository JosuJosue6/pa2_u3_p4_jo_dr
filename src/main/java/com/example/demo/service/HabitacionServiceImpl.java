package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HabitacionRepository;
import com.example.demo.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements HabitacionService {

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Override
	public void agregar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.ingresar(habitacion);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		// TODO Auto-generated method stub
		this.habitacionRepository.actualizar(habitacion);
	}

	@Override
	public void borrarPorId(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepository.eliminarPorId(id);
	}

	@Override
	public Habitacion buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorId(id);
	}

}
