package com.uce.edu.demo.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	
	public void procesarFacturaElectronica(String numero, Integer cantidad, BigDecimal monto);

}
