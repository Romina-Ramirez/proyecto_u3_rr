package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedula, String numero, List<String> codBarras) {
		Cliente cliente = this.clienteRepository.leerPorCedula(cedula);

		List<Detalle> detalles = new ArrayList<>();

		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setNumero(numero);
		factura.setFecha(LocalDateTime.now());

		BigDecimal monto = BigDecimal.ZERO;

		for (String cod : codBarras) {
			Producto producto = this.productoRepository.leerPorCodBarras(cod);

			Detalle detalle = new Detalle();
			detalle.setCantidad(1);
			detalle.setFactura(factura);
			detalle.setProducto(producto);
			detalle.setSubtotal(producto.getPrecio());
			monto = monto.add(detalle.getSubtotal());
			detalles.add(detalle);

			Integer nuevoInventario = producto.getInventario() - 1;
			producto.setInventario(nuevoInventario);
			this.productoRepository.actualizar(producto);
		}

		factura.setDetalles(detalles);

		this.facturaRepository.crear(factura);

		return monto;
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaInnerJoin(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaOuterJoinLeft(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaJoinWhere(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoinLazy(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaInnerJoinLazy(cantidadDetalle);
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		return this.facturaRepository.buscarFacturaJoinFetch(cantidadDetalle);
	}

}
