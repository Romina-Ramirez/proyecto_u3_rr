package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static final Logger logger = Logger.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(CuentaBancaria cuenta) {
		this.entityManager.persist(cuenta);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria leerPorNumero(String numeroCta) {
		logger.info(
				"Transacción activa buscarPorNúmero: " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :numeroCta", CuentaBancaria.class);
		myQuery.setParameter("numeroCta", numeroCta);
		return myQuery.getSingleResult();
	}

	@Override
	public List<CuentaBancaria> leerCuentas() {
		TypedQuery<CuentaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CuentaBancaria c",
				CuentaBancaria.class);
		return myQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(CuentaBancaria cuenta) {
		this.entityManager.merge(cuenta);
		// throw new RuntimeException();
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
	}

}
