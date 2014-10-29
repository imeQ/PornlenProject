package com.pornlen.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the station database table.
 * 
 */
@Entity
@Table(name="station")
public class Station extends AbstractEntity {
	private static final long serialVersionUID = 1L;

    @Temporal( TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	@Column(length=255)
	private String mobStationNumber;

	@Column(length=255)
	private String place;

	@Column(length=255)
	private String sapNumber;

	@Column(length=255)
	private String street;

	@OneToMany(mappedBy="station")
	private List<Schedule> schedules;

    public Station() {
    }

	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getMobStationNumber() {
		return this.mobStationNumber;
	}

	public void setMobStationNumber(String mobStationNumber) {
		this.mobStationNumber = mobStationNumber;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSapNumber() {
		return this.sapNumber;
	}

	public void setSapNumber(String sapNumber) {
		this.sapNumber = sapNumber;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
}