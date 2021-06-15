package com.qa.hwa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

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
	
	public List<CarDTO> getCars(){
		List<Car> cars = this.repo.findAll();
		List<CarDTO> dtos = new ArrayList<>();
		
		for (Car car: cars) {
			CarDTO dto = this.mapper.mapToDTO(car);
			dtos.add(dto);
		}

		return dtos;
	}
	
	public CarDTO updateCar(Integer id, Car newData) {
		Car existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		existing.setMake(newData.getMake());
		existing.setModel(newData.getModel());
		existing.setYear(newData.getYear());
		existing.setColour(newData.getColour());
		existing.setTrans(newData.getTrans());
		existing.setFuel(newData.getFuel());
		existing.setBhp(newData.getBhp());
		existing.setBoughtMileage(newData.getBoughtMileage());
		
		Car updated = this.repo.save(existing);
		return this.mapper.mapToDTO(updated);
	}
}
