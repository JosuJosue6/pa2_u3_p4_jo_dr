package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia",allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;
	
	@Column(name = "tran_fecha")
	private LocalDate fecha;
	
	@Column(name = "tran_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_cta_origen")
	private CuentaBancaria cuentaOrigen;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_cta_destino")
	private CuentaBancaria cuentaDestino;

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

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", cuentaOrigen=" + cuentaOrigen
				+ ", cuentaDestino=" + cuentaDestino + "]";
	}
	
	
}
