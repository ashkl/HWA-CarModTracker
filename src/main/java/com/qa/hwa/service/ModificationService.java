package com.qa.hwa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Car;
import com.qa.hwa.domain.Modification;
import com.qa.hwa.dto.ModificationDTO;
import com.qa.hwa.repo.ModificationRepo;
import com.qa.hwa.utils.ModificationMapper;

@Service
public class ModificationService {
	
	private ModificationRepo repo;
	
	private ModificationMapper mapper;
	
	@Autowired
	public ModificationService(ModificationRepo repo, ModificationMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public ModificationDTO createMod(Modification mod) {
		Modification saved = this.repo.save(mod);
		return this.mapper.mapToDTO(saved);
	}
	
	public List<ModificationDTO> getModsByCar(Integer id){
		Car car = new Car(id);
		List<Modification> mods = this.repo.findByCar(car);
		List<ModificationDTO> dtos =  new ArrayList<>();
		
		ModificationDTO dto = null;
		for (Modification mod : mods) {
			dto = this.mapper.mapToDTO(mod);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public ModificationDTO updateMod(Integer id, Modification newData) {
		Modification existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());
		
		existing.setModName(newData.getModName());
		existing.setModDesc(newData.getModDesc());
		existing.setInstallDate(newData.getInstallDate());
		existing.setInstallMileage(newData.getInstallMileage());
		existing.setModPrice(newData.getModPrice());
		
		Modification updated = this.repo.save(existing);
		return this.mapper.mapToDTO(updated);
	}

}
