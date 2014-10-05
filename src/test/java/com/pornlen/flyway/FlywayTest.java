package com.pornlen.flyway;

import com.pornlen.DomainTestApplication;
import com.pornlen.dao.EntityRepository;
import com.pornlen.domain.DomainProvider;
import com.pornlen.domain.Entity;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DomainTestApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlywayTest {

    @Autowired
    EntityRepository entityRepository;
    @Autowired
    EntityManager entityManager;
    Entity entity = DomainProvider.getRandomEntity();

    @Before
    public void save() throws Exception {
        entityRepository.save(entity);
        entityManager.unwrap(Session.class).flush();
        entityManager.unwrap(Session.class).evict(entity);
    }

    @Test
    @Transactional
    public void testDefaultSettings() throws Exception {
        long count = this.entityRepository.count();
        assertEquals(1, count);
    }
}