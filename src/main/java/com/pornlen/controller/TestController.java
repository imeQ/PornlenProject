package com.pornlen.controller;

import com.pornlen.dao.EntityRepository;
import com.pornlen.domain.DomainProvider;
import com.pornlen.domain.Entity;
import com.pornlen.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;

@Component
@Scope("view")
@ManagedBean//only for autocompletion in xhtml. annotation not working
public class TestController {

    @Autowired
    EntityRepository entityRepository;

    @Autowired
    TestService testService;

    @Transactional
    public void saveTestEntity() {

        System.out.println("saving new entity");
        Entity entity = DomainProvider.getRandomEntity();
        entityRepository.save(entity);
    }

    public String getUserName() {
        return testService.getUserNameFromService();

    }
}
