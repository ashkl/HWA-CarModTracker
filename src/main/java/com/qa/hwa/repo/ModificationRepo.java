package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.hwa.domain.Modification;

public interface ModificationRepo extends JpaRepository<Modification, Integer>{

}
