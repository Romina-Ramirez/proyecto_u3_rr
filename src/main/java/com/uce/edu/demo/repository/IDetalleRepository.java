package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Detalle;

public interface IDetalleRepository {

	public void crear(Detalle detalle);

	public Detalle leer(Integer id);

	public void actualizar(Detalle detalle);

	public void eliminar(Integer id);

}
