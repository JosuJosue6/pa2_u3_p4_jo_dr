package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Hotel;

public interface HotelService {

	public List<Hotel> listarInnerJoin();
	
	public List<Hotel> listarLeftJoin();
	
	public List<Hotel> listarRightJoin();
}
