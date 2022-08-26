package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteRepository {

	public void crear(Cliente cliente);

	public Cliente leerPorCedula(String cedula);

}
