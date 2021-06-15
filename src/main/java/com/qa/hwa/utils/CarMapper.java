package com.qa.hwa.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Car;
import com.qa.hwa.domain.Modification;
import com.qa.hwa.dto.CarDTO;
import com.qa.hwa.dto.ModificationDTO;

@Service
public class CarMapper implements Mapper<Car, CarDTO>{
	
	private ModificationMapper modMapper;

	public CarMapper(ModificationMapper modMapper) {
		super();
		this.modMapper = modMapper;
	}

	@Override
	public CarDTO mapToDTO(Car car) {
		CarDTO dto = new CarDTO();
		dto.setCarId(car.getCarId());
		dto.setMake(car.getMake());
		dto.setModel(car.getModel());
		dto.setYear(car.getYear());
		dto.setColour(car.getColour());
		dto.setTrans(car.getTrans());
		dto.setFuel(car.getFuel());
		dto.setBhp(car.getBhp());
		dto.setBoughtMileage(car.getBoughtMileage());
		List<ModificationDTO> mods = new ArrayList<>();
		if (car.getMods() == null) {
			return dto;
		} else {
			for (Modification mod : car.getMods()) {
				mods.add(this.modMapper.mapToDTO(mod));
			}
			dto.setMods(mods);	
		}
			
		return dto;
	}

	@Override
	public Car mapFromDTO(CarDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
