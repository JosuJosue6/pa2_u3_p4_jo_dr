package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U3P4JoDrApplication implements CommandLineRunner{
	
	@Autowired
	private HotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\nJOIN");
		System.out.println("\nInner Join");
		this.hotelService.listarInnerJoin().forEach(System.out::println);
		//System.out.println(this.hotelService.listarInnerJoin());
		
		System.out.println("\nOUTER JOIN");
		System.out.println("\nLeft Join");
		this.hotelService.listarLeftJoin().forEach(System.out::println);
		
		System.out.println("\nRight Join");
		this.hotelService.listarRightJoin().forEach(System.out::println);
		
		System.out.println("\nHabitacion Left Join");
		this.hotelService.listarHabitacionOuterLefttJoin().forEach(System.out::println);
		
		System.out.println("\nBuscar Full outer Join");
		this.hotelService.listarOuterFullJoin().forEach(System.out::println);
		
		System.out.println("\nBuscar Where Join");
		this.hotelService.listarWhereJoin().forEach(System.out::println);
		
	}

}
