package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;

public interface IFacturaElectronica {

	public void crear(FacturaElectronica facElectronica);

	public FacturaElectronica leer(Integer id);

	public void actualizar(FacturaElectronica facElectronica);

	public void eliminar(Integer id);

	public FacturaElectronica leerPorNumero(String numero);

}
