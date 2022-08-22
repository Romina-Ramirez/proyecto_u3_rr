package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Detalle;

public interface IDetalleService {

	public void insertar(Detalle detalle);

	public Detalle buscar(Integer id);

	public void actualizar(Detalle detalle);

	public void eliminar(Integer id);

}
