package com.pornlen.domain;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 */
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(length = 100)
    private String description;

    @Column(nullable = false)
    private int field;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "role_order", nullable = false)
    private int roleOrder;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<ApplicationUser> applicationUser;

    public Role() {
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

    public List<ApplicationUser> getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(List<ApplicationUser> applicationUser) {
        this.applicationUser = applicationUser;
    }
}