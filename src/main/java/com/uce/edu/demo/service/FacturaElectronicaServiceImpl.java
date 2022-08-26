package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarFacturaElectronica(String numero, Integer cantidad, BigDecimal monto) {

		FacturaElectronica factElect = new FacturaElectronica();

		factElect.setFechaCreacion(LocalDateTime.now());
		factElect.setMonto(monto);
		factElect.setNumero(numero);
		factElect.setNumeroItems(cantidad);

		this.facturaElectronicaRepository.crear(factElect);

		throw new RuntimeException();
	}

}
