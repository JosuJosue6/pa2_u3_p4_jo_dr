package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Provincia;
import com.example.demo.repository.modelo.Semestre;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.MateriaService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U3P4JoDrApplication implements CommandLineRunner{
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaService materiaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//agregar provincia y estudiante
				Provincia provincia1 = new Provincia();
				provincia1.setNombre("Pichincha");
				provincia1.setRegion("Sierra");
				provincia1.setCapital("Quito");
				
				
				Estudiante estudiante1 = new Estudiante();
				estudiante1.setApellido("Ocapana");
				estudiante1.setNombre("Josue");
				estudiante1.setCedula("1720525516");
				estudiante1.setProvincia(provincia1);
				
				List<Estudiante>estuP1 = new ArrayList<>();
				estuP1.add(estudiante1);
				
				provincia1.setEstudiantes(estuP1);
				
				this.estudianteService.agregar(estudiante1);
				
				//agregar materia y semestre
				Semestre semestre1 = new Semestre();
				semestre1.setEstado("matriculado");
				semestre1.setModalidad("Presencial");
				semestre1.setPeriodo("2023-2023");

				Materia materia1 = new Materia();
				materia1.setCodigo("1A");
				materia1.setHorasAcademicas("2");
				materia1.setNombre("PA2");
				materia1.setSemestre(semestre1);
				
				Materia materia2 = new Materia();
				materia2.setCodigo("1B");
				materia2.setHorasAcademicas("4");
				materia2.setNombre("Optimizacion");
				materia2.setSemestre(semestre1);
				
				List<Materia> mM1 = new ArrayList<>();
				mM1.add(materia1);
				mM1.add(materia2);
				
				semestre1.setMaterias(mM1);
				
				this.materiaService.agregar(materia1);
				
				List<String>codigosMateria = new ArrayList<>();
				codigosMateria.add("1A");
				codigosMateria.add("1B");
				
				this.matriculaService.matricular("1720525516", codigosMateria);
		
		
	}

}
