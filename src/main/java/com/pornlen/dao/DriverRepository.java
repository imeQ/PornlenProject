package com.pornlen.dao;

import com.pornlen.domain.Driver;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean//only for autocompletion in xhtml. annotation not working
public interface DriverRepository extends CrudRepository<Driver, Long> {

    @Query("from Driver d where d.pin = ?1 and d.deleted = false")
    List<Driver> findByPin(String pin);

    @Override
    @Query("from Driver d where d.deleted = false")
    List<Driver> findAll();

    @Query("from Driver d")
    List<Driver> findAllWithDeleted();

    @Modifying
    @Transactional(readOnly = false)
    @Query("update Driver d set d.deleted = true where d.pin = ?1")
    Integer softDelete(String pin);

}
