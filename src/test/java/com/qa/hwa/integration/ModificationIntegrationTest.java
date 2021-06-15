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
import com.qa.hwa.domain.Modification;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:hwa-schema.sql", "classpath:hwa-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ModificationIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception{
		Modification testMod = new Modification("Exhaust", "Decat", "15/04/2021", 140000L, 199.99, new Car(1));
		String testModAsJSON = this.mapper.writeValueAsString(testMod);

		Modification testSavedMod = new Modification(4, "Exhaust", "Decat", "15/04/2021", 140000L, 199.99, null);
		String testSavedModAsJSON = this.mapper.writeValueAsString(testSavedMod);
		
		this.mvc.perform( post("/mods/create").content(testModAsJSON).contentType(MediaType.APPLICATION_JSON)).
		andExpect(status().isOk()).andExpect(content().json(testSavedModAsJSON));
	}
}
