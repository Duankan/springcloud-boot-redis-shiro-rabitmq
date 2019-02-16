package com.provider.demo.dao;

import com.provider.demo.entity.JpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * jpa DAO
 */
public interface JpaUsersDao extends CrudRepository<JpaEntity,Integer>{
    public List<JpaEntity> findByUsername(String userName);
    @Query(value = "SELECT * FROM USERS WHERE username = ?1", nativeQuery = true)
    public JpaEntity annotation(String username);
}
