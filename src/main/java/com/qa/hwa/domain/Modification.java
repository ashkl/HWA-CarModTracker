package com.qa.hwa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Modification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer modId;
	
	private String modName;
	private String modDesc;
	private String installDate;
	private Long installMileage;
	private Double modPrice;
	
	@ManyToOne
	private Car car;
	
	public Modification() {
	}

	public Integer getModId() {
		return modId;
	}

	public void setModId(Integer modId) {
		this.modId = modId;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModDesc() {
		return modDesc;
	}

	public void setModDesc(String modDesc) {
		this.modDesc = modDesc;
	}

	public String getInstallDate() {
		return installDate;
	}

	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}

	public Long getInstallMileage() {
		return installMileage;
	}

	public void setInstallMileage(Long installMileage) {
		this.installMileage = installMileage;
	}

	public Double getModPrice() {
		return modPrice;
	}

	public void setModPrice(Double modPrice) {
		this.modPrice = modPrice;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Modification(Integer modId, String modName, String modDesc, String installDate, Long installMileage,
			Double modPrice, Car car) {
		super();
		this.modId = modId;
		this.modName = modName;
		this.modDesc = modDesc;
		this.installDate = installDate;
		this.installMileage = installMileage;
		this.modPrice = modPrice;
		this.car = car;
	}
	
	public Modification(String modName, String modDesc, String installDate, Long installMileage, Double modPrice,
			Car car) {
		super();
		this.modName = modName;
		this.modDesc = modDesc;
		this.installDate = installDate;
		this.installMileage = installMileage;
		this.modPrice = modPrice;
		this.car = car;
	}

	@Override
	public int hashCode() {
		final var prime = 31;
		var result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((installDate == null) ? 0 : installDate.hashCode());
		result = prime * result + ((installMileage == null) ? 0 : installMileage.hashCode());
		result = prime * result + ((modDesc == null) ? 0 : modDesc.hashCode());
		result = prime * result + ((modId == null) ? 0 : modId.hashCode());
		result = prime * result + ((modName == null) ? 0 : modName.hashCode());
		result = prime * result + ((modPrice == null) ? 0 : modPrice.hashCode());
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
		Modification other = (Modification) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (installDate == null) {
			if (other.installDate != null)
				return false;
		} else if (!installDate.equals(other.installDate))
			return false;
		if (installMileage == null) {
			if (other.installMileage != null)
				return false;
		} else if (!installMileage.equals(other.installMileage))
			return false;
		if (modDesc == null) {
			if (other.modDesc != null)
				return false;
		} else if (!modDesc.equals(other.modDesc))
			return false;
		if (modId == null) {
			if (other.modId != null)
				return false;
		} else if (!modId.equals(other.modId))
			return false;
		if (modName == null) {
			if (other.modName != null)
				return false;
		} else if (!modName.equals(other.modName))
			return false;
		if (modPrice == null) {
			if (other.modPrice != null)
				return false;
		} else if (!modPrice.equals(other.modPrice))
			return false;
		return true;
	}
}
