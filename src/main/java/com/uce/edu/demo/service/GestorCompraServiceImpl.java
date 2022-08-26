package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestorCompraServiceImpl implements IGestorCompraService {

	@Autowired
	private IFacturaService facturaService;

	@Autowired
	private IFacturaElectronicaService facturaElectronicaService;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarCompra(String cedula, String numero, List<String> codBarras) {
		BigDecimal total = this.facturaService.procesarFactura(cedula, numero, codBarras);

		this.facturaElectronicaService.procesarFacturaElectronica(numero, codBarras.size(), total);
	}

}
