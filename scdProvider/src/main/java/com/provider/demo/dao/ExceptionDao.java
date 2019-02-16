package com.provider.demo.dao;

import com.provider.demo.entity.Country;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ExceptionDao {
    public List<Country> findAll();
}
