package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha", Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha WHERE ha.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipoHabitacion);
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		return null;
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		return null;
	}

}
