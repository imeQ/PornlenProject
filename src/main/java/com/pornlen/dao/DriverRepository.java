package com.pornlen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pornlen.domain.Driver;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<Driver, Long> {

    @Query("from Driver d where d.pin = ?1 and d.deleted = false")
    List<Driver> findByPin(Integer pin);

    @Query("from Driver d where d.deleted = false order by d.pin")
    List<Driver> findAllActives();

    @Query("from Driver d order by d.pin")
    List<Driver> findAll();

    @Modifying
    @Transactional(readOnly = false)
    @Query("update Driver d set d.deleted = true where d.pin = ?1")
    Integer softDelete(Integer pin);

}
