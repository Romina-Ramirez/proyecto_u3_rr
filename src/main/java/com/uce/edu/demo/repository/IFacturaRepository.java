package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaRepository {

	public void crear(Factura factura);

	public Factura leer(Integer id);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public Factura leerPorNumero(String numero);

	public int actualizarFecha(LocalDateTime fechaAct);

	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle);

	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle);

	public List<Factura> buscarFacturaInnerJoinLazy(Integer cantidadDetalle);

	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle);

}
