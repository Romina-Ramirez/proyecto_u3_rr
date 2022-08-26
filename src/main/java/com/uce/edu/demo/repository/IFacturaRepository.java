package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public void crear(Factura factura);

	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle);

	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle);

	public List<Factura> buscarFacturaInnerJoinLazy(Integer cantidadDetalle);

	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle);

}
