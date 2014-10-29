package com.pornlen.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the driver database table.
 */
@Entity
@Table(name = "driver")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    private Boolean deleted;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date", nullable = false)
    private Date lastModifiedDate;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(length = 255)
    private String location;

    private Integer password;

    private Integer pin;

    //bi-directional many-to-one association to ApplicationUser
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_modified_by", nullable = false)
    private ApplicationUser applicationUser1;

    //bi-directional many-to-one association to ApplicationUser
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private ApplicationUser applicationUser2;

    //bi-directional one-to-one association to DriverContract
    @OneToOne(mappedBy = "driverBean", fetch = FetchType.LAZY)
    private DriverContract driverContract;

    //bi-directional many-to-one association to Schedule
    @OneToMany(mappedBy = "driverBean")
    private List<Schedule> schedules;

    public Driver() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getLastLoginDate() {
        return this.lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public ApplicationUser getApplicationUser1() {
        return this.applicationUser1;
    }

    public void setApplicationUser1(ApplicationUser applicationUser1) {
        this.applicationUser1 = applicationUser1;
    }

    public ApplicationUser getApplicationUser2() {
        return this.applicationUser2;
    }

    public void setApplicationUser2(ApplicationUser applicationUser2) {
        this.applicationUser2 = applicationUser2;
    }

    public DriverContract getDriverContract() {
        return this.driverContract;
    }

    public void setDriverContract(DriverContract driverContract) {
        this.driverContract = driverContract;
    }

    public List<Schedule> getSchedules() {
        return this.schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

}