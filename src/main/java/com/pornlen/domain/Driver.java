package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
@Table(name="driver")
public class Driver extends AuditableEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="first_name", length=255)
	private String firstName;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_login_date")
	private Date lastLoginDate;

	@Column(name="last_name", length=255)
	private String lastName;

	@Column(length=255)
	private String location;

	@Column(length=255)
	private String password;

	@Column(length=255)
	private String pin;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "drivercontract", catalog = "pornlen", joinColumns = { 
			@JoinColumn(name = "contract", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "driver", nullable = false, updatable = false) })
	private List<Contract> contract;
	
    public Driver() {
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

    

	
	
}