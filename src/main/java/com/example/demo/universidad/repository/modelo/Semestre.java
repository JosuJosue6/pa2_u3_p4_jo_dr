package com.example.demo.universidad.repository.modelo;

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
@Table(name = "semestre")
public class Semestre {
	
	@Id
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Column(name = "smt_id")	
	private Integer id;

	@Column(name = "smt_universidad")	
	private String universidad; 

	@Column(name = "smt_nivel")	
	private String nivel;
	
	@Column(name = "smt_facultad")	
	private String facultad;
	
	@OneToMany(mappedBy = "semestre")
	private List<Materia>materias;

	//SET Y GET
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", universidad=" + universidad + ", nivel=" + nivel + ", facultad=" + facultad
				+ "]";
	}
	
	

}
