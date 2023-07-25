package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;




@SpringBootApplication
public class Pa2U3P4JoDrApplication implements CommandLineRunner{
	
/*
 * 
 */
	@Autowired
	private IPropietarioService iPropietarioService;


	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		Propietario propietario = new Propietario();
		propietario.setApellido("Ocapana");
		propietario.setCedula("1720525516");
		propietario.setNombre("Josue");
		
		this.iPropietarioService.agregar(propietario);
	}

}
