package com.example.service.transaction.impl;


import com.example.dao.MethodTestMapper;
import com.example.service.transaction.ServiceB;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description B
 *
 * @author chenmj
 * @date 2021-02-18 15:25
 **/
@Service
public class ServiceBImpl implements ServiceB {

    @Resource
    MethodTestMapper methodTestMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void methodB1() {
        methodTestMapper.insertTest("methodB1");
        int i = 10 / 0;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void methodB2() {
        methodTestMapper.insertTest("methodB2");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public void methodB5() {
        methodTestMapper.insertTest("methodB5");
        int i = 10 / 0;
    }

    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    @Override
    public void methodB3() {
        methodTestMapper.insertTest("methodB3");
    }

    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    @Override
    public void methodB4() {
        methodTestMapper.insertTest("methodB4");
        int i = 10 / 0;
    }
}
