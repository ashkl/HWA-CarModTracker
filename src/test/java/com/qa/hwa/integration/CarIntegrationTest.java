package com.qa.hwa.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.domain.Car;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:hwa-schema.sql", "classpath:hwa-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CarIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception{
		Car testCar = new Car("BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
		String testCarAsJSON = this.mapper.writeValueAsString(testCar);

		Car testSavedCar = new Car(5, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
		String testSavedCarAsJSON = this.mapper.writeValueAsString(testSavedCar);
		
		this.mvc.perform( post("/cars/create").content(testCarAsJSON).contentType(MediaType.APPLICATION_JSON)).
		andExpect(status().isOk()).andExpect(content().json(testSavedCarAsJSON));
	}
	
	@Test
	void testGetAll() throws Exception {
		List<Car> testCars = new ArrayList<>();
		testCars.add(new Car(1, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L));
		testCars.add(new Car(2, "VW", "Polo TSI", 2012, "Candy White", "Manual", "Petrol", 105, 26200L));
		testCars.add(new Car(3, "BMW", "M2", 2017, "Silver", "Manual", "Petrol", 445, 20000L));
		testCars.add(new Car(4, "Audi", "RS3", 2017, "Nardo Grey", "Automatic", "Petrol", 400, 30000L));
		
		String testCarsAsJSONArray = this.mapper.writeValueAsString(testCars);
		
		this.mvc.perform(get("/cars/all")).andExpect(status().isOk()).andExpect(content().json(testCarsAsJSONArray));
	}
	
	@Test
	void testUpdate() throws Exception{
		Car updateCar =  new Car("BMW", "320cd", 2005, "Titanium Silver", "Manual", "Diesel", 300, 120000L);
		String updateCarAsJSON = this.mapper.writeValueAsString(updateCar);
		
		Car updatedCar =  new Car(1, "BMW", "320cd", 2005, "Titanium Silver", "Manual", "Diesel", 300, 120000L);
		String updatedCarAsJSON = this.mapper.writeValueAsString(updatedCar);
		
		this.mvc.perform(put("/cars/update/1").content(updateCarAsJSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(updatedCarAsJSON));
	}
}
