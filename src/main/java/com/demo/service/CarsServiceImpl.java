package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CarsDao;
import com.demo.entity.Cars;

@Service
public class CarsServiceImpl implements CarsService{

	@Autowired
	CarsDao dao;
	
	@Override
	public boolean addCar(Cars car) {
		
		return dao.addCar(car);
	}

	@Override
	public List<Cars> getAllCars() {
		return dao.getAllCars();
	}

	@Override
	public Cars getCar(int id) {
		return dao.getCar(id);
	}

	@Override
	public boolean deleteCar(int id) {
		return dao.deleteCar(id);
	}

	@Override
	public boolean updateCarDetails(Cars car, int id) {
		return dao.updateCarDetails(car, id);
	}

}
