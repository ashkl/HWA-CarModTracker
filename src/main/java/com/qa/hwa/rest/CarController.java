package com.qa.hwa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}
