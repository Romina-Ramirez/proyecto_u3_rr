package com.uce.edu.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	private static final Logger logger = Logger.getLogger(HotelServiceImpl.class);

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		return this.hotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft() {
		return this.hotelRepository.buscarHotelOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		return this.hotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		logger.info("Transacción activa service: " + TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepository.buscarHotelJoinFetch(tipoHabitacion);
	}

}
