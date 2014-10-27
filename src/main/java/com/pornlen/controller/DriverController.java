package com.pornlen.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pornlen.dao.DriverRepository;
import com.pornlen.domain.Driver;
import com.pornlen.service.UserService;

@Component
@Scope("view")
@ManagedBean
public class DriverController {

    @Autowired
    DriverRepository driverRepository;
    
    @Autowired
    UserService userService;

    @Transactional
    public void saveDriver() {
      
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAllActives();

    }
}
 