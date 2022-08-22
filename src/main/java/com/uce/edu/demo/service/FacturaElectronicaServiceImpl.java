package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronica;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronica facElectronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(FacturaElectronica facElectronica) {
		this.facElectronicaRepository.crear(facElectronica);
	}

	@Override
	public FacturaElectronica buscar(Integer id) {
		return this.facElectronicaRepository.leer(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(FacturaElectronica facElectronica) {
		this.facElectronicaRepository.actualizar(facElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.facElectronicaRepository.eliminar(id);
	}

	@Override
	public FacturaElectronica buscarPorNumero(String numero) {
		return this.facElectronicaRepository.leerPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarFactSRI(Factura factura) {
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(factura.getNumero());
		facturaElectronica.setFechaCreacion(LocalDateTime.now());
		facturaElectronica.setNumeroItems(factura.getDetalles().size());

		BigDecimal monto = new BigDecimal(0);

		for (Detalle detalle : factura.getDetalles())
			monto = monto.add(detalle.getSubtotal());

		facturaElectronica.setMonto(monto);

		this.insertar(facturaElectronica);
	}

}
