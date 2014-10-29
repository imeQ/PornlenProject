package com.pornlen.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the contract database table.
 * 
 */
@Entity
@Table(name = "contract")
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 100)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "contract")
	private List<Driver> drivers;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "contract")
	private List<Vehicle> vehicles;

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

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}