package com.rafalowczarski.zadanie.resources.refuels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Refuel {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String date;
	private FuelTypes fuelType;
	private Integer fuelAmount;
	private Double unitPrice;
	private Integer meterStatus;
	private String driverName;
	
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public FuelTypes getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelTypes fuelType) {
		this.fuelType = fuelType;
	}
	public Integer getFuelAmount() {
		return fuelAmount;
	}
	public void setFuelAmount(Integer fuelAmount) {
		this.fuelAmount = fuelAmount;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getMeterStatus() {
		return meterStatus;
	}
	public void setMeterStatus(Integer meterStatus) {
		this.meterStatus = meterStatus;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
}
