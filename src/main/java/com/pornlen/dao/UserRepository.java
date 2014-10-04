package com.pornlen.dao;

import com.pornlen.domain.User;
import org.springframework.data.repository.CrudRepository;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean//only for autocompletion in xhtml. annotation not working
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
}
