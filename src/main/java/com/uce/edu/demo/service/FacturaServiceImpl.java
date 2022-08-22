package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IDetalleRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	private static final Logger logger = Logger.getLogger(FacturaServiceImpl.class);

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IDetalleRepository detalleRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IFacturaElectronicaService facElectronicaService;

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

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Factura factura) {
		this.facturaRepository.crear(factura);
	}

	@Override
	public Factura buscar(Integer id) {
		return this.facturaRepository.leer(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Factura factura) {
		this.facturaRepository.actualizar(factura);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.facturaRepository.eliminar(id);
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		return this.facturaRepository.leerPorNumero(numero);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public int actualizarFecha(LocalDateTime fechaAct) {
		return this.facturaRepository.actualizarFecha(fechaAct);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearFactura(String numero, String cedula, String... codBarras) {
		Factura f = new Factura();
		f.setNumero(numero);
		f.setFecha(LocalDateTime.now());
		f.setCliente(this.clienteRepository.leerPorCedula(cedula));
		this.insertar(f);

		List<Detalle> detalles = new ArrayList<Detalle>();
		for (String codigoProducto : codBarras) {
			Detalle detalle = new Detalle();
			detalle.setCantidad(1);
			detalle.setFactura(f);
			Producto producto = this.productoRepository.leerPorCodBarras(codigoProducto);
			detalle.setProducto(producto);
			producto.setInventario(producto.getInventario() - 1);

			if (producto.getInventario() >= 0) {
				detalle.setSubtotal(detalle.getProducto().getPrecio());
				detalles.add(detalle);
				this.detalleRepository.crear(detalle);
				this.productoRepository.actualizar(producto);
			} else {
				logger.error("Stock agotado del producto: " + producto.getNombre());
				continue;
			}
		}

		f.setDetalles(detalles);
		try {
			this.facElectronicaService.guardarFactSRI(f);
		} catch (Exception e) {
			logger.error("ERROR con Factura Electronica");
		}
	}

}
