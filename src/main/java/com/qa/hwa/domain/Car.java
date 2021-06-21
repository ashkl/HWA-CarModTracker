package com.qa.hwa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer carId;
	
	private String make;
	private String model;
	private Integer year;
	private String colour;
	private String trans;
	private String fuel;
	private Integer bhp;
	private Long boughtMileage;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
	@JsonIgnore
	private List<Modification> mods;
	
	public Car() {
	}

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

	public List<Modification> getMods() {
		return mods;
	}

	public Car(Integer carId, String make, String model, Integer year, String colour, String trans, String fuel,
			Integer bhp, Long boughtMileage, List<Modification> mods) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.colour = colour;
		this.trans = trans;
		this.fuel = fuel;
		this.bhp = bhp;
		this.boughtMileage = boughtMileage;
		this.mods = mods;
	}

	public Car(String make, String model, Integer year, String colour, String trans, String fuel, Integer bhp,
			Long boughtMileage) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.colour = colour;
		this.trans = trans;
		this.fuel = fuel;
		this.bhp = bhp;
		this.boughtMileage = boughtMileage;
	}

	public Car(Integer carId, String make, String model, Integer year, String colour, String trans, String fuel,
			Integer bhp, Long boughtMileage) {
		super();
		this.carId = carId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.colour = colour;
		this.trans = trans;
		this.fuel = fuel;
		this.bhp = bhp;
		this.boughtMileage = boughtMileage;
	}

	public Car(Integer carId) {
		super();
		this.carId = carId;
	}

	@Override
	public int hashCode() {
		final var prime = 31;
		var result = 1;
		result = prime * result + ((bhp == null) ? 0 : bhp.hashCode());
		result = prime * result + ((boughtMileage == null) ? 0 : boughtMileage.hashCode());
		result = prime * result + ((carId == null) ? 0 : carId.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((fuel == null) ? 0 : fuel.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((mods == null) ? 0 : mods.hashCode());
		result = prime * result + ((trans == null) ? 0 : trans.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (bhp == null) {
			if (other.bhp != null)
				return false;
		} else if (!bhp.equals(other.bhp))
			return false;
		if (boughtMileage == null) {
			if (other.boughtMileage != null)
				return false;
		} else if (!boughtMileage.equals(other.boughtMileage))
			return false;
		if (carId == null) {
			if (other.carId != null)
				return false;
		} else if (!carId.equals(other.carId))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (fuel == null) {
			if (other.fuel != null)
				return false;
		} else if (!fuel.equals(other.fuel))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (mods == null) {
			if (other.mods != null)
				return false;
		} else if (!mods.equals(other.mods))
			return false;
		if (trans == null) {
			if (other.trans != null)
				return false;
		} else if (!trans.equals(other.trans))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
}

