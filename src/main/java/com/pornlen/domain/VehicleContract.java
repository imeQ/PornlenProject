package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehicle_contract database table.
 * 
 */
@Entity
@Table(name="vehicle_contract")
public class VehicleContract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int vehicle;

	//bi-directional many-to-one association to Contract
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contract")
	private Contract contractBean;

	//bi-directional one-to-one association to Vehicle
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicle", nullable=false, insertable=false, updatable=false)
	private Vehicle vehicleBean;

    public VehicleContract() {
    }

	public int getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}

	public Contract getContractBean() {
		return this.contractBean;
	}

	public void setContractBean(Contract contractBean) {
		this.contractBean = contractBean;
	}
	
	public Vehicle getVehicleBean() {
		return this.vehicleBean;
	}

	public void setVehicleBean(Vehicle vehicleBean) {
		this.vehicleBean = vehicleBean;
	}
	
}