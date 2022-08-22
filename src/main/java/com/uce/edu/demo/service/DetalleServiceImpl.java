package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IDetalleRepository;
import com.uce.edu.demo.repository.modelo.Detalle;

@Service
public class DetalleServiceImpl implements IDetalleService {

	@Autowired
	private IDetalleRepository detalleRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Detalle detalle) {
		this.detalleRepository.crear(detalle);
	}

	@Override
	public Detalle buscar(Integer id) {
		return this.detalleRepository.leer(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Detalle detalle) {
		this.detalleRepository.actualizar(detalle);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.detalleRepository.eliminar(id);
	}

}
