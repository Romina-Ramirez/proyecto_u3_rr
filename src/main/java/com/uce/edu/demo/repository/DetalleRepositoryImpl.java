package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Detalle;

@Repository
@Transactional
public class DetalleRepositoryImpl implements IDetalleRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void crear(Detalle detalle) {
		this.entityManager.persist(detalle);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Detalle leer(Integer id) {
		return this.entityManager.find(Detalle.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Detalle detalle) {
		this.entityManager.merge(detalle);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.leer(id));
	}

}
