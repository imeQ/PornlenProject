package com.pornlen.domain;

@javax.persistence.Entity
public class ApplicationUser extends AbstractEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
