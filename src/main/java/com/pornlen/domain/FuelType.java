package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fuel_type database table.
 * 
 */
@Entity
@Table(name="fuel_type")
public class FuelType extends AbstractEntity {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date lastModifiedDate;

	@Column(length=255)
	private String name;

	@OneToMany(mappedBy="fuelType")
	private List<Schedule> schedules;

    public FuelType() {
    }

public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}