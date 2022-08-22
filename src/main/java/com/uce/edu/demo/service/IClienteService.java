package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteService {

	public void insertar(Cliente cliente);

	public Cliente buscar(Integer id);

	public void actualizar(Cliente cliente);

	public void eliminar(Integer id);

	public Cliente buscarPorCedula(String cedula);

}
