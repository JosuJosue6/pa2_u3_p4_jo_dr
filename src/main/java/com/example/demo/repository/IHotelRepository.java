package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public List<Hotel> seleccionarInnerJoin();
	
	public List<Hotel> seleccionarOuterLeftJoin();
	
	public List<Hotel> seleccionarOuterRightJoin();
	
	public List<Habitacion> seleccionarHabitacionOuterLefttJoin();
	
	public List<Hotel> seleccionarOuterFullJoin();
	
	public List<Hotel> seleccionarWhereJoin();
}
