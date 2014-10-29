package com.pornlen.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the application_user_role database table.
 * 
 */
@Entity
@Table(name="application_user_role")
public class ApplicationUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="application_user", unique=true, nullable=false)
	private int applicationUser;

	//bi-directional one-to-one association to ApplicationUser
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="application_user", nullable=false, insertable=false, updatable=false)
	private ApplicationUser applicationUserBean;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role", nullable=false)
	private Role roleBean;

    public ApplicationUserRole() {
    }

	public int getApplicationUser() {
		return this.applicationUser;
	}

	public void setApplicationUser(int applicationUser) {
		this.applicationUser = applicationUser;
	}

	public ApplicationUser getApplicationUserBean() {
		return this.applicationUserBean;
	}

	public void setApplicationUserBean(ApplicationUser applicationUserBean) {
		this.applicationUserBean = applicationUserBean;
	}
	
	public Role getRoleBean() {
		return this.roleBean;
	}

	public void setRoleBean(Role roleBean) {
		this.roleBean = roleBean;
	}
	
}