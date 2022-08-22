package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {

	public void insertar(Factura factura);

	public Factura buscar(Integer id);

	public void actualizar(Factura factura);

	public void eliminar(Integer id);

	public Factura buscarPorNumero(String numero);

	public int actualizarFecha(LocalDateTime fechaAct);

	public void crearFactura(String numero, String cedula, String... codBarras);

	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle);

	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle);

	public List<Factura> buscarFacturaInnerJoinLazy(Integer cantidadDetalle);

	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle);

}
