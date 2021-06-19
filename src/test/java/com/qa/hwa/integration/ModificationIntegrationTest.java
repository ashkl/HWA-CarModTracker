package com.qa.hwa.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.qa.hwa.domain.Modification;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // prevents port conflicts
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:hwa-schema.sql", "classpath:hwa-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
class ModificationIntegrationTest {

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
	
	@Test
	void testFindByCar() throws Exception {
		List<Modification> mods = new ArrayList<>();
		mods.add(new Modification(2, "Exhaust", "Catback Exhaust", "15/11/2018", 40000L, 370.00, null));
		mods.add(new Modification(3, "Splitter", "TRC Front Splitter", "26/01/2020", 60000L, 370.00, null));
		
		String testModsAsJSONArray = this.mapper.writeValueAsString(mods);
		
		this.mvc.perform(get("/mods/findByCar/2")).andExpect(status().isOk()).andExpect(content().json(testModsAsJSONArray));
	}
	
	@Test
	void testUpdate() throws Exception{
		Modification updateMod =  new Modification("Full Exhaust", "Turbo back Exhaust", "15/11/2018", 40000L, 420.00, null);
		String updateModAsJSON = this.mapper.writeValueAsString(updateMod);
		
		Modification updatedMod =  new Modification(2, "Full Exhaust", "Turbo back Exhaust", "15/11/2018", 40000L, 420.00, null);
		String updatedModAsJSON = this.mapper.writeValueAsString(updatedMod);
		
		this.mvc.perform(put("/mods/update/2").content(updateModAsJSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().json(updatedModAsJSON));
	}
	
	@Test
	void testRemove() throws Exception {
		this.mvc.perform(delete("/mods/remove/1")).andExpect(status().isOk()).andExpect(content().string("true"));
	}
}