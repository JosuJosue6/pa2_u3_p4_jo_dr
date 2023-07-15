package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Habitacion;
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
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Hotel> listarRightJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Habitacion> listarHabitacionOuterLefttJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionOuterLefttJoin();
	}

	@Override
	public List<Hotel> listarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> listarWhereJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> listarJoinFetch() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFetchJoin();
	}

	@Override
	public void agregar(Hotel hotel) {
		// TODO Auto-generated method stub
		//Habitacion habitacion = new Habitacion();
		for(Habitacion ha: hotel.getHabitaciones()) {
			ha.setValorIncluidoIva(ha.getValor().multiply(new BigDecimal(1.12)));
			System.out.println(ha.getValorIncluidoIva());
		}
	
		this.hotelRepository.insertar(hotel);
	}



	
}
