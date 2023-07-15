package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelService {

	public List<Hotel> listarInnerJoin();
	
	public List<Hotel> listarLeftJoin();
	
	public List<Hotel> listarRightJoin();
	
	public List<Habitacion> listarHabitacionOuterLefttJoin();
	
	public List<Hotel> listarOuterFullJoin();
	
	public List<Hotel> listarWhereJoin();
	
	public List<Hotel> listarJoinFetch();
	
	public void agregar(Hotel hotel);

}
