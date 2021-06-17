package com.qa.hwa.dto;

import java.util.List;

public class CarDTO {

	private Integer carId;
	
	private String make;
	private String model;
	private Integer year;
	private String colour;
	private String trans;
	private String fuel;
	private Integer bhp;
	private Long boughtMileage;

	private List<ModificationDTO> mods;
	
	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Integer getBhp() {
		return bhp;
	}

	public void setBhp(Integer bhp) {
		this.bhp = bhp;
	}

	public Long getBoughtMileage() {
		return boughtMileage;
	}

	public void setBoughtMileage(Long boughtMileage) {
		this.boughtMileage = boughtMileage;
	}

	public List<ModificationDTO> getMods() {
		return mods;
	}

	public void setMods(List<ModificationDTO> mods) {
		this.mods = mods;
	}

	public CarDTO() {
		// TODO Auto-generated constructor stub
	}
}