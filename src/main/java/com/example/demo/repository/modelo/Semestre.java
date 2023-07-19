package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
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
	@GeneratedValue(generator = "seq_semestre",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Column(name = "seme_id")
	private Integer id;
	
	@Column(name = "seme_modalidad")
	private String modalidad;
	
	@Column(name = "seme_estado")
	private String estado;//matriculado, inscrito
	
	@Column(name = "seme_periodo")
	private String periodo;
	
	@OneToMany(mappedBy = "semestre",cascade = CascadeType.ALL)
	private List<Materia> materias;

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Semestre [id=" + id + ", modalidad=" + modalidad + ", estado=" + estado + ", periodo=" + periodo + "]";
	}
	
	
}
