package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public void crear(CuentaBancaria cuenta);

	public List<CuentaBancaria> leerCuentas();

	public void actualizar(CuentaBancaria cuenta);

	public CuentaBancaria leerPorNumero(String numeroCta);

	public void eliminar(Integer id);
}
