package com.pornlen.dao;

import com.pornlen.domain.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean//only for autocompletion in xhtml. annotation not working
public interface UserRepository extends CrudRepository<ApplicationUser, Long> {

    List<ApplicationUser> findByName(String name);
}
