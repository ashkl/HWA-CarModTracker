package com.qa.hwa.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

		Car testSavedCar = new Car(1, "BMW", "320cd", 2005, "Silver", "Manual", "Diesel", 210, 120000L);
		String testSavedCarAsJSON = this.mapper.writeValueAsString(testSavedCar);
		
		this.mvc.perform( post("/cars/create").content(testCarAsJSON).contentType(MediaType.APPLICATION_JSON)).
		andExpect(status().isOk()).andExpect(content().json(testSavedCarAsJSON));
	}
}
