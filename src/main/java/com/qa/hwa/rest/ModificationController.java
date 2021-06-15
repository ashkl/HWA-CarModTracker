package com.qa.hwa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/findByCar/{id}")
	public List<ModificationDTO> getModsByCar(@PathVariable int id){
		return this.service.getModsByCar(id);
	}
	
	@PutMapping("/update/{id}")
	public ModificationDTO updateMod(@RequestBody Modification mod, @PathVariable int id) {
		return this.service.updateMod(id, mod);
	}
	
	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}
}
