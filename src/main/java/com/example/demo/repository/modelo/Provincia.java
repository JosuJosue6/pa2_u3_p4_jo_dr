package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {
	
	@Id
	@GeneratedValue(generator = "seq_provincia",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_nombre")
	private String nombre;
	
	@Column(name = "prov_region")
	private String region;
	
	@Column(name = "prov_capital")
	private String capital;
	
	@OneToMany(mappedBy = "provincia")
	private List<Estudiante> estudiantes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", region=" + region + ", capital=" + capital
				+"]";
	}
	
	
	
}
