package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public List<Hotel> listarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> listarLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarLeftJoin();
	}

	@Override
	public List<Hotel> listarRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarRightJoin();
	}


	
}
