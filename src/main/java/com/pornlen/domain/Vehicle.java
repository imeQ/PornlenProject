package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@Table(name="vehicle")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(nullable=false, length=255)
	private String number;

	@Column(name="side_number", length=255)
	private String sideNumber;

	@Column(name="vehicle_type", nullable=false, length=1)
	private String vehicleType;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="vehicle1")
	private List<Schedule> schedules1;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="vehicle2")
	private List<Schedule> schedules2;

	//bi-directional one-to-one association to VehicleContract
	@OneToOne(mappedBy="vehicleBean", fetch=FetchType.LAZY)
	private VehicleContract vehicleContract;

    public Vehicle() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSideNumber() {
		return this.sideNumber;
	}

	public void setSideNumber(String sideNumber) {
		this.sideNumber = sideNumber;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public List<Schedule> getSchedules1() {
		return this.schedules1;
	}

	public void setSchedules1(List<Schedule> schedules1) {
		this.schedules1 = schedules1;
	}
	
	public List<Schedule> getSchedules2() {
		return this.schedules2;
	}

	public void setSchedules2(List<Schedule> schedules2) {
		this.schedules2 = schedules2;
	}
	
	public VehicleContract getVehicleContract() {
		return this.vehicleContract;
	}

	public void setVehicleContract(VehicleContract vehicleContract) {
		this.vehicleContract = vehicleContract;
	}
	
}