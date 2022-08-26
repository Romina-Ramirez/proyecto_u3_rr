package com.uce.edu.demo.service;

import java.util.List;

public interface IGestorCompraService {

	public void realizarCompra(String cedula, String numero, List<String> codBarras);

}
