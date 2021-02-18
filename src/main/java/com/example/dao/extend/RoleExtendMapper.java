package com.example.dao.extend;

import com.example.dao.RoleMapper;
import com.example.domain.Role;

import java.util.List;

public interface RoleExtendMapper extends RoleMapper {

    List<Role> getAllRoles();
}
