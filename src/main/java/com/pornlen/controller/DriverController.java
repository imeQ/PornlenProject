package com.pornlen.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import com.pornlen.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pornlen.domain.Driver;

@Component
@Scope("view")
@ManagedBean
public class DriverController {

    @Autowired
    DriverService driverService;

    @Transactional
    public void saveDriver() {

    }

    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

}
 