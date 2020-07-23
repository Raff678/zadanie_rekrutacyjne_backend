package com.rafalowczarski.zadanie.resources.refuels;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REFUELS")
@Getter
@Setter	
class Refuel implements Serializable{
    
	private static final long serialVersionUID = -5539448798311012547L;

	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message = "Date can't be empty")
	private String date;
	@NotNull(message = "Fuel type must be chosen")
	private FuelTypes fuelType;
	@NotNull(message = "Fuel can't be empty")
	private Double fuelAmount;
	@NotNull(message = "Price can't be empty")
	private Double unitPrice;
	@NotNull(message = "Meter can't be empty")
	private Double meterStatus;
	private String driverName;
}
