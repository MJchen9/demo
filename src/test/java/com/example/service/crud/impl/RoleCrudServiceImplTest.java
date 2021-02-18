package com.example.service.crud.impl;

import com.example.DemoApplication;
import com.example.domain.Role;
import com.example.service.crud.IRoleCrudService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class RoleCrudServiceImplTest {

    @Autowired
    private IRoleCrudService iRoleCrudService;

    @Test
    public void addRole() {
        Role role = new Role();
        role.setRoleName("测试");
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        role.setStatus("NORMAL");
        Long id = iRoleCrudService.addRole(role);
        System.out.println("id = " + id);
    }

    @Test
    public void updateRole() {
        Role role = new Role();
        role.setId(80L);
        role.setUpdateTime(new Date());
        role.setStatus("DELETE");
        iRoleCrudService.updateRole(role);
    }

    @Test
    public void getAllRoles() {
        iRoleCrudService.getAllRoles();
    }
}