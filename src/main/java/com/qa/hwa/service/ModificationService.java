package com.qa.hwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
