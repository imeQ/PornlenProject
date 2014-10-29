package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the terminal database table.
 * 
 */
@Entity
@Table(name="terminal")
public class Terminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String code;

	@Column(name="expected_unloading", length=255)
	private String expectedUnloading;

	@Column(name="expected_unloading_address", length=255)
	private String expectedUnloadingAddress;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(length=255)
	private String name;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="terminal1")
	private List<Schedule> schedules1;

	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="terminal2")
	private List<Schedule> schedules2;

    public Terminal() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExpectedUnloading() {
		return this.expectedUnloading;
	}

	public void setExpectedUnloading(String expectedUnloading) {
		this.expectedUnloading = expectedUnloading;
	}

	public String getExpectedUnloadingAddress() {
		return this.expectedUnloadingAddress;
	}

	public void setExpectedUnloadingAddress(String expectedUnloadingAddress) {
		this.expectedUnloadingAddress = expectedUnloadingAddress;
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
	
}