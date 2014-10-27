package com.pornlen.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.pornlen.dao.UserRepository;
import com.pornlen.domain.ApplicationUser;

@Component
@Scope("view")
@ManagedBean
public class UserController {

    @Autowired
    UserRepository userRepository;
    

    public List<ApplicationUser> getUsers() {
        return userRepository.findAllActives();	
    }
}
 