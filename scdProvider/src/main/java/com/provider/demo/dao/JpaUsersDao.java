package com.provider.demo.dao;

import com.provider.demo.entity.JpaEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;
import java.util.List;


/**
 * @author dankin
 * @date 2019-03-01 重新写注释
 * @descr JPADao的使用 JpaUsersDao继承了CrudRepository会自动注入扫描
 * 并且CrudRepository里面已经封装了一些基础的方法
 */
public interface JpaUsersDao extends CrudRepository<JpaEntity, Integer>,JpaSpecificationExecutor<JpaEntity> {
    public List<JpaEntity> findByUsername(String userName);//会自动拼接这样的sql语句

    @Query(value = "SELECT * FROM USERS WHERE username = ?1", nativeQuery = true)
    public JpaEntity annotation(String username);
}
