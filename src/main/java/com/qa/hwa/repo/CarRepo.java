package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.hwa.domain.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
