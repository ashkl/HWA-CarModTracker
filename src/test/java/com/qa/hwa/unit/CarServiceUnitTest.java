package com.qa.hwa.unit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.hwa.domain.Car;
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

}
