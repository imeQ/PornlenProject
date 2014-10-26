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
public class Terminal extends AbstractEntity {

    private String code;

    private String name;

    private String expectedUnloading;

    private String expectedUnloadingAddress;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "terminal")
    private Set<Schedule> scheduleSet = new HashSet<Schedule>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "unloadTerminal")
    private Set<Schedule> scheduleUnloadSet = new HashSet<Schedule>(0);

    public Terminal() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpectedUnloading() {
        return expectedUnloading;
    }

    public void setExpectedUnloading(String expectedUnloading) {
        this.expectedUnloading = expectedUnloading;
    }

    public String getExpectedUnloadingAddress() {
        return expectedUnloadingAddress;
    }

    public void setExpectedUnloadingAddress(String expectedUnloadingAddress) {
        this.expectedUnloadingAddress = expectedUnloadingAddress;
    }

    public Set<Schedule> getScheduleSet() {
        return scheduleSet;
    }

    public void setScheduleSet(Set<Schedule> scheduleSet) {
        this.scheduleSet = scheduleSet;
    }

    public Set<Schedule> getScheduleUnloadSet() {
        return scheduleUnloadSet;
    }

    public void setScheduleUnloadSet(Set<Schedule> scheduleUnloadSet) {
        this.scheduleUnloadSet = scheduleUnloadSet;
    }
}
