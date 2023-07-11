package com.example.demo.repository;

import com.example.demo.repository.modelo.Habitacion;

public interface HabitacionRepository {

	public void ingresar(Habitacion habitacion);
	
	public void actualizar(Habitacion habitacion);
	
	public void eliminarPorId(Integer id);
	
	public Habitacion seleccionarPorId(Integer id);
}
