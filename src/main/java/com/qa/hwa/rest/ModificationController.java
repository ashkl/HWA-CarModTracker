package com.qa.hwa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Modification;
import com.qa.hwa.dto.ModificationDTO;
import com.qa.hwa.service.ModificationService;

@RestController
@RequestMapping("/mods")
public class ModificationController {
	
	private ModificationService service;
	
	@Autowired
	public ModificationController(ModificationService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ModificationDTO createMod(@RequestBody Modification mod) {
		return this.service.createMod(mod);
	}
}
