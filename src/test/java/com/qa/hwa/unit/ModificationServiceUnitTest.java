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
import com.qa.hwa.domain.Modification;
import com.qa.hwa.dto.ModificationDTO;
import com.qa.hwa.repo.ModificationRepo;
import com.qa.hwa.service.ModificationService;
import com.qa.hwa.utils.ModificationMapper;

@SpringBootTest
@ActiveProfiles("test")
public class ModificationServiceUnitTest {

	@Autowired
	private ModificationService service;
	
	@MockBean
	private ModificationRepo repo;
	
	@MockBean
	private ModificationMapper mapper;
	
	@Test
	void testCreate() {
		//GIVEN
		Modification testMod = new Modification("Spoiler", "M4 Style Spoiler", "15/06/2021", 135000L, 54.99, new Car(1));
		Modification testSavedMod = new Modification(1, "Spoiler", "M4 Style Spoiler", "15/06/2021", 135000L, 54.99, null);
		
		//WHEN
		Mockito.when(this.repo.save(testMod)).thenReturn(testMod);
		
		//THEN
		assertThat(this.service.createMod(testMod)).isEqualTo(this.mapper.mapToDTO(testSavedMod));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(testMod);
	}
	
	@Test
	void testFindByCar() {
		int Id = 2;
		List<Modification> mods = new ArrayList<>();
		mods.add(new Modification("Exhaust", "Catback Exhaust", "15/11/2018", 40000L, 370.00, null));
		mods.add(new Modification("Splitter", "TRC Front Splitter", "26/01/2020", 60000L, 370.00, null));
		
		List<ModificationDTO> dtos = new ArrayList<>();
		for (Modification mod: mods) {
			ModificationDTO dto = this.mapper.mapToDTO(mod);
			dtos.add(dto);
		}
		
		Mockito.when(this.repo.findByCar(new Car(Id))).thenReturn(mods);
		
		assertThat(this.service.getModsByCar(Id)).isEqualTo(dtos);
		
		Mockito.verify(this.repo, Mockito.times(1)).findByCar(new Car(Id));
	}
}
