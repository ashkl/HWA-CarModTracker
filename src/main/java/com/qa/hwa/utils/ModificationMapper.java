package com.qa.hwa.utils;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Modification;
import com.qa.hwa.dto.ModificationDTO;

@Service
public class ModificationMapper implements Mapper<Modification, ModificationDTO>{

	@Override
	public ModificationDTO mapToDTO(Modification mod) {
		ModificationDTO dto = new ModificationDTO();
		
		dto.setModId(mod.getModId());
		dto.setModName(mod.getModName());
		dto.setModDesc(mod.getModDesc());
		dto.setInstallDate(mod.getInstallDate());
		dto.setInstallMileage(mod.getInstallMileage());
		dto.setModPrice(mod.getModPrice());
		
		return dto;
	}

	@Override
	public Modification mapFromDTO(ModificationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
