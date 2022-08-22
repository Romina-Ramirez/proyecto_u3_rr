package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.modelo.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Cliente cliente) {
		this.clienteRepository.crear(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		return this.clienteRepository.leer(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.clienteRepository.eliminar(id);
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		return this.clienteRepository.leerPorCedula(cedula);
	}

}
