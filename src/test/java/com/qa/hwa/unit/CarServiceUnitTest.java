package com.qa.hwa.unit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hwa.domain.Car;
import com.qa.hwa.dto.CarDTO;
import com.qa.hwa.repo.CarRepo;
import com.qa.hwa.service.CarService;
import com.qa.hwa.utils.CarMapper;

@SpringBootTest
@ActiveProfiles("test")
public class CarServiceUnitTest {
	
	@Autowired
	private CarService service;
	
	@MockBean
	private CarRepo repo;
	
	@MockBean
	private CarMapper mapper;
	
	@Test
	void testCreate() {
		//GIVEN
		Car testCar = new Car("BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
		Car testSavedCar = new Car(1, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L, null);
		
		//WHEN
		Mockito.when(this.repo.save(testCar)).thenReturn(testCar);
		
		//THEN
		assertThat(this.service.createCar(testCar)).isEqualTo(this.mapper.mapToDTO(testSavedCar));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(testCar);
	}
	
	@Test
	void testGetAll() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car(1, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L));
		cars.add(new Car(2, "VW", "Polo TSI", 2012, "Candy White", "Manual", "Petrol", 105, 26200L));
		cars.add(new Car(3, "BMW", "M2", 2017, "Silver", "Manual", "Petrol", 445, 20000L));
		cars.add(new Car(4, "Audi", "RS3", 2017, "Nardo Grey", "Automatic", "Petrol", 400, 30000L));
		
		List<CarDTO> dtos = new ArrayList<>();
		for (Car car: cars) {
			CarDTO dto = this.mapper.mapToDTO(car);
			dtos.add(dto);
		}
		
		Mockito.when(this.repo.findAll()).thenReturn(cars);
		
		assertThat(this.service.getCars()).isEqualTo(dtos);
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

}
