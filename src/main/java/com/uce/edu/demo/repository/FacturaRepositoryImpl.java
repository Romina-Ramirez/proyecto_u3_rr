package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void crear(Factura factura) {
		this.entityManager.persist(factura);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura leer(Integer id) {
		return this.entityManager.find(Factura.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Factura factura) {
		this.entityManager.merge(factura);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		this.entityManager.remove(this.leer(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura leerPorNumero(String numero) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero > :numero",
				Factura.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public int actualizarFecha(LocalDateTime fechaAct) {
		Query query = this.entityManager.createQuery("UPDATE Factura f SET f.fecha = :fechaAct");
		query.setParameter("fechaAct", fechaAct);
		return query.executeUpdate();
	}

}
