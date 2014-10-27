package com.pornlen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pornlen.domain.ApplicationUser;

@Repository
public interface UserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

    List<ApplicationUser> findByName(String name);
    
    @Query("from ApplicationUser a order by a.name")
    List<ApplicationUser> findAllActives();
}
