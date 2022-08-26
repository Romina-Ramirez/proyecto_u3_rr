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
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Detalle;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class GestorCompraServiceImpl implements IGestorCompraService {
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarCompra(String cedula, String numero, List<String> codBarras) {
		
		Cliente cliente = this.clienteRepository.leerPorCedula(cedula);
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setNumero(numero);
		factura.setFecha(LocalDateTime.now());
		
		List<Detalle> detalles = new ArrayList<>();
		
		for(String cod : codBarras) {
			Producto producto = this.productoRepository.leerPorCodBarras(cod);
			
			Detalle detalle = new Detalle();
			detalle.setCantidad(1);
			detalle.setFactura(factura);
			detalle.setProducto(producto);
			detalle.setSubtotal(producto.getPrecio());
			
			detalles.add(detalle);
			
			Integer nuevoInventario = producto.getInventario() - 1;
			producto.setInventario(nuevoInventario);
			this.productoRepository.actualizar(producto);
		}
		
		factura.setDetalles(detalles);
		
		this.facturaRepository.crear(factura);
		
		BigDecimal monto = BigDecimal.ZERO;
		
		FacturaElectronica factElectronica = new FacturaElectronica();
		factElectronica.setFechaCreacion(LocalDateTime.now());
		factElectronica.setNumero(numero);
		
		for(Detalle detalle : detalles) {
			monto = monto.add(detalle.getSubtotal());
		}
		
		factElectronica.setMonto(monto);
		factElectronica.setNumeroItems(detalles.size());
		
		this.facturaElectronicaRepository.crear(factElectronica);
		
	}

}
