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
@Table(name = "propietario")
public class Propietario {

	@Id
	@GeneratedValue(generator = "seq_propietario", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario",allocationSize = 1)
	@Column(name = "prop_id")
	private Integer id;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@Column(name = "prop_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "propietario")
	private List<CuentaBancaria> cuentasB;

	//SET Y GET
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<CuentaBancaria> getCuentasB() {
		return cuentasB;
	}

	public void setCuentasB(List<CuentaBancaria> cuentasB) {
		this.cuentasB = cuentasB;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
	}
	
	
}
