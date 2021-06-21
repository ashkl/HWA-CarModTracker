package com.qa.hwa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Car;
import com.qa.hwa.dto.CarDTO;
import com.qa.hwa.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	private CarService service;
	
	@Autowired
	public CarController(CarService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public CarDTO createCar(@RequestBody Car car) {
		return this.service.createCar(car);
	}
	
	@GetMapping("/all")
	public List<CarDTO> getCars(){
		return this.service.getCars();
	}
	
	@PutMapping("/update/{id}")
	public CarDTO updateCar(@RequestBody Car car, @PathVariable int id) {
		return this.service.updateCar(id, car);
	}
	
	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}
}
