package com.provider.demo.dao;

import com.provider.demo.dto.CountryDto;
import com.provider.demo.entity.Country;

public interface CountryMapper {

    int deleteByPrimaryKey(Integer cid);
    int insert(Country record);
    int insertSelective(Country record);
    Country selectByPrimaryKey(Integer cid);
    int updateByPrimaryKeySelective(Country record);
    int updateByPrimaryKey(Country record);
}