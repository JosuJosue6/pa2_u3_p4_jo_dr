package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public List<Hotel> seleccionarInnerJoin();
	
	public List<Hotel> seleccionarLeftJoin();
	
	public List<Hotel> seleccionarRightJoin();
}
