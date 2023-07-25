package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ITransferenciaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository transferenciaRepository;

	@Autowired
	private ICuentaBancariaService bancariaService;

	@Override
	public void agregar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.actualizar(transferencia);
	}

	@Override
	public Transferencia buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionarPorID(id);
	}

	@Override
	public void borrarPorID(Integer id) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.eliminarPorID(id);
	}

	@Override
	public List<Transferencia> buscarTransferenciasPorNumeroCuenta(String numeroCuentaS) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionarTransferenciasPorNumeroCuenta(numeroCuentaS);
	}

	@Override
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria cOrigen = this.bancariaService.buscarPorNumero(cuentaOrigen);
		CuentaBancaria cDestino = this.bancariaService.buscarPorNumero(cuentaDestino);
		BigDecimal saldo = cOrigen.getSaldo();
		if (monto.compareTo(saldo) == 1) {
			System.out
					.println("Lo sentimos es imposible realizar la transferencia pues su saldo es insuficiente... :c");
		} else {
			
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(cOrigen);
			transferencia.setCuentaDestino(cDestino);
			transferencia.setFecha(LocalDate.now());
			transferencia.setMonto(monto);
			List<Transferencia>transferenciaL = new ArrayList<>();
			transferenciaL.add(transferencia);
			
			//Aumento a cuenta destino
			BigDecimal saldoActual = cDestino.getSaldo();
			cDestino.setSaldo(saldoActual.add(monto));
			this.bancariaService.actualizar(cDestino);
			System.out.println("Transferencia exitosa :).");
			
			//restar saldo
			BigDecimal saldoActualO = cOrigen.getSaldo();
			cOrigen.setSaldo(saldoActualO.subtract(monto));
			cOrigen.setTransferencias(transferenciaL);
			this.bancariaService.actualizar(cOrigen);
		}
	}

}
