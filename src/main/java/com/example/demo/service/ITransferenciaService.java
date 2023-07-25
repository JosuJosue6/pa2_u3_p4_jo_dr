package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface ITransferenciaService {

	public void agregar(Transferencia transferencia);
	
	public void actualizar(Transferencia transferencia);
	
	public Transferencia buscarPorID(Integer id);
	
	public void borrarPorID(Integer id);

	public List<Transferencia> buscarTransferenciasPorNumeroCuenta(String numeroCuentaS);
	
	public void realizarTransferencia(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
}
