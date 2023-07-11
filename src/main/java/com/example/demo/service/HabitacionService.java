package com.example.demo.service;

import com.example.demo.repository.modelo.Habitacion;

public interface HabitacionService{

	public void agregar(Habitacion habitacion);
	
	public void actualizar(Habitacion habitacion);
	
	public void borrarPorId(Integer id);
	
	public Habitacion buscarPorId(Integer id);
	
}
