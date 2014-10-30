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

}