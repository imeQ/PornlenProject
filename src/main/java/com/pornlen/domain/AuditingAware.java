package com.pornlen.domain;

import com.pornlen.dao.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class AuditingAware implements AuditorAware<ApplicationUser> {

    private final static Logger log = LoggerFactory.getLogger(AuditingAware.class);

	private static final String TEMP_USER_NAME = "Mietek";

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApplicationUser getCurrentAuditor() {
    	List<ApplicationUser> users = userRepository.findByName(TEMP_USER_NAME);
    	if(users.isEmpty())
    		throw new IllegalStateException("Execute flyway migration task");
    	return users.get(0);
//        //TODO fix me with proper logic in prod
//        log.warn("here we dynamically create a user for audting. Fix in prod");
//        SecurityContext securityContext = SecurityContextHolder.getContext();
////        if (securityContext.getAuthentication() == null) {
////            ApplicationUser randomApplicationUser = DomainProvider.getRandomUser();
////            userRepository.save(randomApplicationUser);
////            return randomApplicationUser;
////        }
//        String userName = securityContext.getAuthentication().getName();
//        List<ApplicationUser> applicationUserByName = userRepository.findByName(userName);
//        if (CollectionUtils.isEmpty(applicationUserByName)) {
//            ApplicationUser applicationUser = new ApplicationUser();
//            applicationUser.setName(userName);
//            userRepository.save(applicationUser);
//            return applicationUser;
//        }
//        return applicationUserByName.get(0);
    }
}
