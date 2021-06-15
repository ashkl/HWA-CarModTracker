package com.qa.hwa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.hwa.domain.Car;
import com.qa.hwa.domain.Modification;

public interface ModificationRepo extends JpaRepository<Modification, Integer>{

	List<Modification> findByCar(Car car);

}
