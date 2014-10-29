package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the application_user database table.
 * 
 */
@Entity
@Table(name="application_user")
public class ApplicationUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_modified_date", nullable=false)
	private Date lastModifiedDate;

	@Column(length=255)
	private String name;

	//bi-directional one-to-one association to ApplicationUserRole
	@OneToOne(mappedBy="applicationUserBean", fetch=FetchType.LAZY)
	private ApplicationUserRole applicationUserRole;

	//bi-directional many-to-one association to Driver
	@OneToMany(mappedBy="applicationUser1")
	private List<Driver> drivers1;

	//bi-directional many-to-one association to Driver
	@OneToMany(mappedBy="applicationUser2")
	private List<Driver> drivers2;

    public ApplicationUser() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ApplicationUserRole getApplicationUserRole() {
		return this.applicationUserRole;
	}

	public void setApplicationUserRole(ApplicationUserRole applicationUserRole) {
		this.applicationUserRole = applicationUserRole;
	}
	
	public List<Driver> getDrivers1() {
		return this.drivers1;
	}

	public void setDrivers1(List<Driver> drivers1) {
		this.drivers1 = drivers1;
	}
	
	public List<Driver> getDrivers2() {
		return this.drivers2;
	}

	public void setDrivers2(List<Driver> drivers2) {
		this.drivers2 = drivers2;
	}
	
}