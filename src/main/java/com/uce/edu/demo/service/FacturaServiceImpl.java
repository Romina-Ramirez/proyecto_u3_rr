package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaInnerJoin(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaOuterJoinLeft(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaJoinWhere(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoinLazy(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaInnerJoinLazy(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaJoinFetch(cantidadDetalle);
	}

}
