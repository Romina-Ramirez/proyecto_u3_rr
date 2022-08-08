package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f INNER JOIN f.detalles d WHERE d.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, Detalle d WHERE f = d.factura AND d.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoinLazy(Integer cantidadDetalle) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f INNER JOIN f.detalles d WHERE d.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidadDetalle);
		// Bajo demanda
		List<Factura> facturas = myQuery.getResultList();
		for (Factura f : facturas) {
			f.getDetalles().size();
		}
		return facturas;
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidadDetalle);
		return myQuery.getResultList();
	}

}
