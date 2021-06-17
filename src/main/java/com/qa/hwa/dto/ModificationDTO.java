package com.qa.hwa.dto;

import com.qa.hwa.domain.Car;

public class ModificationDTO {

	private Integer modId;
	
	private String modName;
	private String modDesc;
	private String installDate;
	private Long installMileage;
	private Double modPrice;
	
	private Car car;

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

	public ModificationDTO() {
		// TODO Auto-generated constructor stub
	}
}
