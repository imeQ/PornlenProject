package com.pornlen.service;

import com.pornlen.dao.DriverRepository;
import com.pornlen.domain.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public List<Driver> getDrivers() {
        return driverRepository.findAllActives();
    }

}
