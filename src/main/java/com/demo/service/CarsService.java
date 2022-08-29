package com.demo.service;

import java.util.List;

import com.demo.entity.Cars;

public interface CarsService {
	
	public boolean addCar(Cars car);

	public List<Cars> getAllCars();

	public Cars getCar(int id);

	public boolean deleteCar(int id);

	public boolean updateCarDetails(Cars car, int id);
}
