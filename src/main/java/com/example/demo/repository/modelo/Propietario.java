package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "propietario")
public class Propietario {

	/*
	@Id
	@GeneratedValue(generator = "seq_propietario", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_propietario", sequenceName = "seq_propietario", allocationSize = 1)
	@Column(name = "prop_id")
	private Integer id;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@Column(name = "prop_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "propietario", fetch = FetchType.LAZY)
	private List<CuentaBancaria> cuentas;*/
}
