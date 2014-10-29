package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=100)
	private String description;

	@Column(nullable=false)
	private int field;

	@Column(nullable=false, length=100)
	private String name;

	@Column(name="role_order", nullable=false)
	private int roleOrder;

	//bi-directional many-to-one association to ApplicationUserRole
	@OneToMany(mappedBy="roleBean")
	private List<ApplicationUserRole> applicationUserRoles;

    public Role() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getField() {
		return this.field;
	}

	public void setField(int field) {
		this.field = field;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoleOrder() {
		return this.roleOrder;
	}

	public void setRoleOrder(int roleOrder) {
		this.roleOrder = roleOrder;
	}

	public List<ApplicationUserRole> getApplicationUserRoles() {
		return this.applicationUserRoles;
	}

	public void setApplicationUserRoles(List<ApplicationUserRole> applicationUserRoles) {
		this.applicationUserRoles = applicationUserRoles;
	}
	
}