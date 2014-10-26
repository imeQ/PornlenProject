package com.pornlen.domain;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lolcat on 26.10.14.
 */

@javax.persistence.Entity
public class Station extends AbstractEntity {

    private String sapNumber;

    private String mobStationNumber;

    private String place;

    private String street;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "station")
    private Set<Schedule> scheduleSet = new HashSet<Schedule>(0);


    public Station() {
    }

    public String getSapNumber() {
        return sapNumber;
    }

    public void setSapNumber(String sapNumber) {
        this.sapNumber = sapNumber;
    }

    public String getMobStationNumber() {
        return mobStationNumber;
    }

    public void setMobStationNumber(String mobStationNumber) {
        this.mobStationNumber = mobStationNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Set<Schedule> getScheduleSet() {
        return scheduleSet;
    }

    public void setScheduleSet(Set<Schedule> scheduleSet) {
        this.scheduleSet = scheduleSet;
    }
}
