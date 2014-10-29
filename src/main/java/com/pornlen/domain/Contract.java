package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contract database table.
 * 
 */
@Entity
@Table(name="contract")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to DriverContract
	@OneToMany(mappedBy="contractBean")
	private List<DriverContract> driverContracts;

	//bi-directional many-to-one association to VehicleContract
	@OneToMany(mappedBy="contractBean")
	private List<VehicleContract> vehicleContracts;

    public Contract() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DriverContract> getDriverContracts() {
		return this.driverContracts;
	}

	public void setDriverContracts(List<DriverContract> driverContracts) {
		this.driverContracts = driverContracts;
	}
	
	public List<VehicleContract> getVehicleContracts() {
		return this.vehicleContracts;
	}

	public void setVehicleContracts(List<VehicleContract> vehicleContracts) {
		this.vehicleContracts = vehicleContracts;
	}
	
}