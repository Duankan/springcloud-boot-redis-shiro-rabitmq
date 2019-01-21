package com.provider.demo.service.impl;

import com.provider.demo.dao.PermissionMapper;
import com.provider.demo.entity.Permission;
import com.provider.demo.service.UserManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserManagerImpl implements UserManager{
    @Resource
    PermissionMapper permissionMapper;
    @Override
    public Permission getPermissionById(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }
}
