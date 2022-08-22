package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {

	public void crear(Producto producto);

	public Producto leer(Integer id);

	public void actualizar(Producto producto);

	public void eliminar(Integer id);

	public Producto leerPorCodBarras(String codBarras);

}
