package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
//Rompimiento
@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@GeneratedValue(generator = "seq_matricula",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@Column(name = "matr_id")
	private Integer id;
	
	@Column(name = "matr_fecha")
	private LocalDate fecha;
	
	@Column(name = "matr_numero")
	private String numero;
	
	@Column(name = "matr_estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_estudiante")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "matr_id_materia")
	private Materia materia;

	@Transient
	private List<String> codigosMateria;
	
	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	public List<String> getCodigosMateria() {
		return codigosMateria;
	}

	public void setCodigosMateria(List<String> codigosMateria) {
		this.codigosMateria = codigosMateria;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fecha=" + fecha + ", numero=" + numero + ", estado=" + estado
				+ ", estudiante=" + estudiante + ", materia=" + materia + "]";
	}
	
	
	
}
