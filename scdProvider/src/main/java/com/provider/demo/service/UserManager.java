package com.provider.demo.service;

import com.provider.demo.entity.Country;
import com.provider.demo.entity.Permission;

public interface UserManager {
    public Permission getPermissionById(Integer id);
    public Country getCountryByCid(Integer id);
}
