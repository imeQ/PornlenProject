package com.pornlen.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vehicle database table.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false, length = 255)
    private String number;

    @Column(name = "side_number", length = 255)
    private String sideNumber;

    @Column(name = "vehicle_type", nullable = false, length = 1)
    private String vehicleType;

    //bi-directional many-to-one association to Schedule
    @OneToMany(mappedBy = "truck")
    private List<Schedule> schedulesTruck;

    @OneToMany(mappedBy = "semiTrailer")
    private List<Schedule> schedulesSemiTrailer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "vehiclecontract", catalog = "pornlen", joinColumns = {
            @JoinColumn(name = "contract", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "vehicle", nullable = false, updatable = false)})
    private List<Contract> contract;

    public Vehicle() {
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSideNumber() {
        return this.sideNumber;
    }

    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<Schedule> getSchedulesTruck() {
        return schedulesTruck;
    }

    public void setSchedulesTruck(List<Schedule> schedulesTruck) {
        this.schedulesTruck = schedulesTruck;
    }

    public List<Schedule> getSchedulesSemiTrailer() {
        return schedulesSemiTrailer;
    }

    public void setSchedulesSemiTrailer(List<Schedule> schedulesSemiTrailer) {
        this.schedulesSemiTrailer = schedulesSemiTrailer;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}