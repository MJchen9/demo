package com.example.service.crud;

import com.example.domain.Role;

import java.util.List;

/**
 * Description 角色 CRUD Service
 *
 * @author chenmj
 * @date 2020-12-17 15:20
 **/
public interface IRoleCrudService {

    Long addRole(Role role);

    Long updateRole(Role role);

    List<Role> getAllRoles();
}
