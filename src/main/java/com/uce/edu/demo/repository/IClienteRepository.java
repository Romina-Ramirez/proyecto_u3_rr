package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteRepository {
	
	public void crear(Cliente cliente);
	
	public Cliente leer(Integer id);

	public void actualizar(Cliente cliente);

	public void eliminar(Integer id);

	public Cliente leerPorCedula(String cedula);

}
