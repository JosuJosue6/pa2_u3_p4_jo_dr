package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
/*
	@Id
	@GeneratedValue(generator = "seq_cta_bancaria", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_cta_bancaria", sequenceName = "seq_cta_bancaria", allocationSize = 1)
	@Column(name = "cta_id")
	private Integer id;
	
	@Column(name = "cta_numero")
	private String numero;
	
	@Column(name = "cta_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cta_tipo")
	private String tipo;
	
	@JoinColumn(name = "cta_id_propietario")
	@OneToMany
	private Propietario propietario;
	
	
	private List<Transferencia> transferencias; 

	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo
				+ ", propietario=" + propietario + "]";
	}
	
	*/
}
