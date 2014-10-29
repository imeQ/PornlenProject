package com.pornlen.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the terminal database table.
 */
@Entity
@Table(name = "terminal")
public class Terminal extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(length = 255)
    private String code;

    private String expectedUnloading;

    private String expectedUnloadingAddress;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(length = 255)
    private String name;

    @OneToMany(mappedBy = "loadTerminal")
    private List<Schedule> loadSchedules;

    @OneToMany(mappedBy = "unloadTerminal")
    private List<Schedule> unloadSchedules;

    public Terminal() {
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

    public List<Schedule> getLoadSchedules() {
        return loadSchedules;
    }

    public void setLoadSchedules(List<Schedule> loadSchedules) {
        this.loadSchedules = loadSchedules;
    }

    public List<Schedule> getUnloadSchedules() {
        return unloadSchedules;
    }

    public void setUnloadSchedules(List<Schedule> unloadSchedules) {
        this.unloadSchedules = unloadSchedules;
    }
}