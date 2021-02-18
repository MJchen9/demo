package com.example.service.crud.impl;

import com.example.dao.extend.RoleExtendMapper;
import com.example.domain.Role;
import com.example.service.crud.IRoleCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description 角色 CRUD Service
 *
 * @author chenmj
 * @date 2020-12-17 15:23
 **/
@Transactional(rollbackFor = Exception.class)
@Service
@Slf4j
public class RoleCrudServiceImpl implements IRoleCrudService {

    @Autowired
    private RoleExtendMapper roleMapper;


    @CachePut(value = "roleCache", key = "#result+''")
    @Override
    public Long addRole(Role role) {
        roleMapper.insertSelective(role);
        return role.getId();
    }

    @CacheEvict(value = "roleCache", key = "'roleId:'.#role.id.toString()")
    @Override
    public Long updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
        return role.getId();
    }

    @Cacheable(value = "roleCache", key = "#root.targetClass.getName()")
    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }
}
