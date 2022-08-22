package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaImpl implements IFacturaElectronica {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void crear(FacturaElectronica facElectronica) {
		this.entityManager.persist(facElectronica);
		throw new RuntimeException();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaElectronica leer(Integer id) {
		return this.entityManager.find(FacturaElectronica.class, id);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(FacturaElectronica facElectronica) {
		this.entityManager.merge(facElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.leer(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaElectronica leerPorNumero(String numero) {
		TypedQuery<FacturaElectronica> myQuery = this.entityManager.createQuery(
				"SELECT fe FROM FacturaElectronica fe WHERE fe.numero = :numero", FacturaElectronica.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
