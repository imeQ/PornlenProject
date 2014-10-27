package com.pornlen.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.common.collect.Lists;
import com.pornlen.dao.DriverRepository;
import com.pornlen.domain.Driver;

@Controller
@RequestMapping("/rest/drivers")
public class DriverEndpoint {

    @Autowired
    private DriverRepository driverRepository;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Driver> findAll() {
    	return Lists.newArrayList(driverRepository.findAllActives());
    }

    @RequestMapping(value = "/pin/{pin}", method = RequestMethod.GET)
    public ResponseEntity<Driver> getByPin(@PathVariable int pin) {
        List<Driver> drivers = driverRepository.findByPin(pin);
        return new ResponseEntity<>(drivers != null ? drivers.get(0) : null, HttpStatus.OK);
    }

}
