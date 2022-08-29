package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Cars;
import com.demo.service.CarsService;

@RestController
public class MyController {

	@Autowired
	public CarsService service;

	@PostMapping("/car")
	private ResponseEntity<?> add(@RequestBody Cars car) {
	if (service.addCar(car))
		return ResponseEntity.ok("Car added successfully....");
	else 
		return ResponseEntity.ok("Unable to add car....");
	}
	
	@GetMapping("/cars")
	private ResponseEntity<?> get(){
		return ResponseEntity.ok(service.getAllCars());
	}
	
	@GetMapping("/cars/{id}")
	private ResponseEntity<?> get(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.getCar(Integer.parseInt(id)));
	}
	
	@DeleteMapping("/car/{id}")
	private ResponseEntity<?> delete(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.deleteCar(Integer.parseInt(id)));	
	}
	
	@PutMapping("/car/{id}")
	private ResponseEntity<?> update(@RequestBody Cars car , @PathVariable("id") String id){
		return ResponseEntity.ok(service.updateCarDetails(car, Integer.parseInt(id)));
	}
}




