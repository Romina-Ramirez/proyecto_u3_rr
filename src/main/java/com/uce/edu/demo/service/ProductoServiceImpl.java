package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		this.productoRepository.crear(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		return this.productoRepository.leer(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Producto producto) {
		this.productoRepository.actualizar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.productoRepository.eliminar(id);
	}

	@Override
	public Producto buscarPorCodBarras(String codBarras) {
		return this.productoRepository.leerPorCodBarras(codBarras);
	}

}
