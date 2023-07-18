package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.HotelService;
import com.example.demo.universidad.repository.MateriaRepository;
import com.example.demo.universidad.repository.modelo.Estudiante;
import com.example.demo.universidad.repository.modelo.Materia;
import com.example.demo.universidad.repository.modelo.Matricula;
import com.example.demo.universidad.repository.modelo.Provincia;
import com.example.demo.universidad.repository.modelo.Semestre;
import com.example.demo.universidad.service.EstudianteService;
import com.example.demo.universidad.service.MatriculaService;

@SpringBootApplication
public class Pa2U3P4JoDrApplication implements CommandLineRunner{
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaRepository materiaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	//Provincia
		//Falata setear estudiante
		Provincia provincia1 = new Provincia();
		provincia1.setNombre("Loja");
		provincia1.setCapital("Loja");
		provincia1.setRegion("Sierra");
		
		Provincia provincia2 = new Provincia();
		provincia2.setNombre("Guayaquil");
		provincia2.setCapital("Guayas");
		provincia2.setRegion("Costa");
		
		//Estudiante
		//Falta setear matriculas
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setApellido("Ocapana");
		estudiante1.setNombre("Josue");
		estudiante1.setCedula("1720525516");
		estudiante1.setProvincia(provincia1);
		
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setApellido("Rivas");
		estudiante2.setNombre("Diego");
		estudiante2.setCedula("1425051146");
		estudiante2.setProvincia(provincia2);
		
		this.estudianteService.agregar(estudiante1);
		this.estudianteService.agregar(estudiante2);
		
		//Semestre
		//FALTA MATERIAS
		Semestre semestre1 = new Semestre();
		semestre1.setFacultad("Ing Ciencias");
		semestre1.setUniversidad("UCE");
		semestre1.setNivel("9no");
		
		Semestre semestre2 = new Semestre();
		semestre2.setFacultad("Medicina");
		semestre2.setUniversidad("UCE");
		semestre2.setNivel("4no");
		
		
		//Materia
		Materia materia1 = new Materia();
		materia1.setCodigo("11");
		materia1.setDocente("Sandrita");
		materia1.setNombre("IA");
		materia1.setSemestre(semestre1);
		
		Materia materia2 = new Materia();
		materia2.setCodigo("22");
		materia2.setDocente("Albuja");
		materia2.setNombre("Anatomia Avanzada");
		materia2.setSemestre(semestre2);
		
		Materia materia3 = new Materia();
		materia3.setCodigo("33");
		materia3.setDocente("Vivas");
		materia3.setNombre("Optimizacion");
		materia3.setSemestre(semestre1);
		
		this.materiaRepository.insertar(materia1);
		this.materiaRepository.insertar(materia2);
		this.materiaRepository.insertar(materia3);
		//
		List<Materia> materiaIng = new ArrayList<>();
		materiaIng.add(materia1);
		materiaIng.add(materia3);
		
		List<Materia> materiaMed = new ArrayList<>();
		materiaMed.add(materia2);		
		
		
		
		this.matriculaService.matricular( "1720525516", materia1);
		
		
	}

}
