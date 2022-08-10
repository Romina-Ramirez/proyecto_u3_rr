package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Autowired
	private ITransferenciaRepository transferenciaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// 0. Busque la cuenta origen (obtener el saldo)
		CuentaBancaria ctaOrigen = this.bancariaRepository.leerPorNumero(numeroCtaOrigen);

		// 1. Restar el monto a la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);

		// 0. Busque la cuenta destino (obtener el saldo)
		CuentaBancaria ctaDestino = this.bancariaRepository.leerPorNumero(numeroCtaDestino);

		// 2. Sumar el monto a la cuenta destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);

		// 3. Insertar la transferencia
		Transferencia transferencia = new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		transferencia.setCuentaOrigen(ctaOrigen);
		transferencia.setCuentaDestino(ctaDestino);
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String CtaOrigen, String CtaDestino, BigDecimal monto) {
		this.realizarTransferencia(CtaOrigen, CtaDestino, monto);
	}

}
