package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle);

}
