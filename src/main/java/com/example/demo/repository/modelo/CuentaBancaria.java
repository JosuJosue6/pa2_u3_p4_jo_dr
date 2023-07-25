package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(generator = "seq_cta_bancaria", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_cta_bancaria", sequenceName = "seq_cta_bancaria",allocationSize = 1)
	@Column(name = "ctab_id")
	private Integer id;
	
	@Column(name = "ctab_numero")
	private String numero;
	
	@Column(name = "ctab_saldo")
	private BigDecimal saldo;
	
	@Column(name = "ctab_tipo")
	private String tipo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ctab_id_propietario")
	private Propietario propietario;
	
	@OneToMany(mappedBy = "cuentaOrigen", cascade = CascadeType.ALL)
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

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}
	
	
}
