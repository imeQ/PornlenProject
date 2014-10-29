package com.pornlen.domain;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pornlen.DomainTestApplication;
import com.pornlen.dao.DriverRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DomainTestApplication.class)
public class DriverTest {

    private static final String FIRST_NAME = "Bob";
    private static final String LAST_NAME = "Faggot";
    private static final String LOCATION = "Edinburgh";
    private static final Integer PIN = 1234;
    private static final Integer PASSWORD = 123;
    private static final String TEST = "Test";
    public static final Integer PIN2 = 4321;

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    EntityManager entityManager;

    StandardPasswordEncoder encoder;

    @Before
    public void init() throws Exception {

        Driver driver = new Driver();
        driver.setFirstName(FIRST_NAME);
        driver.setLastName(LAST_NAME);
        driver.setLocation(LOCATION);
        driver.setLastLoginDate(new Date());

   //     driver.setPassword(PASSWORD);
       // setupPassword(driver);
  //      driver.setPin(PIN);

        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setName(TEST);

   //     driver.setCreatedBy(applicationUser);

        driverRepository.save(driver);
        entityManager.unwrap(Session.class).flush();
        entityManager.unwrap(Session.class).evict(driver);
    }

    private void setupPassword(Driver driver) {
        encoder = new StandardPasswordEncoder();
    //    String result = encoder.encode(RAW_PASSWORD);
 //       driver.setPassword(result);
    }

    @Test
    @Transactional
    public void driverExists() {
        Iterable<Driver> driversList = driverRepository.findAll();
        assertThat(driversList, notNullValue());
        assertThat(driversList.iterator().hasNext(), is(true));
    }

    @Test
    @Transactional
    public void passwordMatches() {
        Driver driver = driverRepository.findAll().iterator().next();
   //     assertThat(encoder.matches(RAW_PASSWORD, driver.getPassword()), is(true));
    }

    @Test
    @Transactional
    public void driverFieldsMatch() {
        Driver driver = driverRepository.findAll().iterator().next();

   //     assertThat(driver.getCreatedBy(), notNullValue());
  //      assertThat(driver.getLastModifiedBy(), notNullValue());
        assertThat(driver.getCreatedDate(), notNullValue());
        assertThat(driver.getLastModifiedDate(), notNullValue());
        assertThat(driver.getFirstName(), is(FIRST_NAME));
        assertThat(driver.getLastName(), is(LAST_NAME));
        assertThat(driver.getLocation(), is(LOCATION));
        assertThat(driver.getLastLoginDate(), notNullValue());
        assertThat(driver.getPin(), is(PIN));
    }

    @Test
    @Transactional
    public void findDriverByPin() {
        List<Driver> driversByPin = driverRepository.findByPin(PIN);
        Driver driver = driversByPin.iterator().next();

        assertThat(driversByPin, notNullValue());
        assertThat(driver.getPin(), is(PIN));
    }

    @Test
    @Transactional
    public void updateDriver() {
        Driver driver = driverRepository.findAll().iterator().next();
  //      driver.setPin(PIN2);
        driverRepository.save(driver);
 //       entityManager.unwrap(Session.class).flush();
 //       entityManager.unwrap(Session.class).evict(driver);

   //     List<Driver> driversByPin = driverRepository.findByPin(PIN2);

 //       assertThat(driversByPin, notNullValue());
  //     assertThat(driversByPin.iterator().next().getPin(), is(PIN2));
    }

    @Test
    @Transactional
    public void deleteDriver() {
        driverRepository.deleteAll();
        Iterable<Driver> drivers = driverRepository.findAll();

        assertThat(drivers.iterator().hasNext(), is(false));
    }

    @Test
    @Transactional
    public void softDeleteDriver() {
    	  Iterable<Driver> driversActive = driverRepository.findAllActives();
//        assertThat(driversActive.iterator().hasNext(), is(true));

        driverRepository.softDelete(PIN);

        Iterable<Driver> driversAfterDel = driverRepository.findAllActives();
        assertThat(driversAfterDel.iterator().hasNext(), is(false));

        List<Driver> driversByPin = driverRepository.findByPin(PIN);
        assertThat(driversByPin.iterator().hasNext(), is(false));


        List<Driver> allDriversWithDeleted = driverRepository.findAll();
        assertThat(allDriversWithDeleted.iterator().next().getDeleted(), is(true));

    }
}