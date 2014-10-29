package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the station database table.
 * 
 */
@Entity
@Table(name="station")
public class Station implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(name="mob_station_number", length=255)
	private String mobStationNumber;

	@Column(length=255)
	private String place;

	@Column(name="sap_number", length=255)
	private String sapNumber;

	@Column(length=255)
	private String street;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="stationBean")
	private List<Schedule> schedules;

    public Station() {
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