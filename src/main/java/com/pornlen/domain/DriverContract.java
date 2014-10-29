package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the driver_contract database table.
 * 
 */
@Entity
@Table(name="driver_contract")
public class DriverContract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int driver;

	//bi-directional many-to-one association to Contract
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="contract")
	private Contract contractBean;

	//bi-directional one-to-one association to Driver
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="driver", nullable=false, insertable=false, updatable=false)
	private Driver driverBean;

    public DriverContract() {
    }

	public int getDriver() {
		return this.driver;
	}

	public void setDriver(int driver) {
		this.driver = driver;
	}

	public Contract getContractBean() {
		return this.contractBean;
	}

	public void setContractBean(Contract contractBean) {
		this.contractBean = contractBean;
	}
	
	public Driver getDriverBean() {
		return this.driverBean;
	}

	public void setDriverBean(Driver driverBean) {
		this.driverBean = driverBean;
	}
	
}