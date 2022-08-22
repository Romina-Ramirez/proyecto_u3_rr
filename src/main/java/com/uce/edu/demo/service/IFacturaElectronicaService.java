package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

public interface IFacturaElectronicaService {

	public void insertar(FacturaElectronica facElectronica);

	public FacturaElectronica buscar(Integer id);

	public void actualizar(FacturaElectronica facElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica buscarPorNumero(String numero);

	public void guardarFactSRI(Factura factura);

}
