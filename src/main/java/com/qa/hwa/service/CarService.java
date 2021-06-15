package com.qa.hwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Car;
import com.qa.hwa.dto.CarDTO;
import com.qa.hwa.repo.CarRepo;
import com.qa.hwa.utils.CarMapper;

@Service
public class CarService {
	
	private CarRepo repo;
	
	private CarMapper mapper;
	
	@Autowired
	public CarService(CarRepo repo, CarMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public CarDTO createCar(Car car) {
		Car saved = this.repo.save(car);
		return this.mapper.mapToDTO(saved);
	}
}
