package com.example.service.transaction.impl;


import com.example.dao.MethodTestMapper;
import com.example.service.transaction.ServiceA;
import com.example.service.transaction.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Description A
 *
 * @author chenmj
 * @date 2021-02-18 15:25
 **/
@Service
public class ServiceAImpl implements ServiceA {

    @Resource
    MethodTestMapper methodTestMapper;

    @Autowired
    ServiceB serviceB;

    @Override
    public void methodA1() {
        methodTestMapper.insertTest("methodA1");
        serviceB.methodB1();
        // @Transactional的事务开启 ，或者是基于接口的 或者是基于类的代理被创建。所以在同一个类中一个无事务的方法调用另一个有事务的方法，事务是不会起作用的
//        methodA4();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void methodA2() {
        try {
            // REQUIRED 只要内层方法报错抛出异常，即使外层有try-catch，该事务也会回滚
            serviceB.methodB1();
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
        }
        methodTestMapper.insertTest("methodA2");
        // REQUIRES_NEW 内层报错回滚，然后又会抛出异常，外层如果没有捕获处理内层抛出来的这个异常，外层还是会回滚的。
//        serviceB.methodB5();
        // REQUIRES_NEW 内层报错回滚，外层try-catch内层的异常，外层不会回滚。
//        try {
//            serviceB.methodB5();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void methodA3() {
        serviceB.methodB2();
        methodTestMapper.insertTest("methodA3");
        // REQUIRES_NEW 外层报错回滚，不影响内层
        throw new RuntimeException();
        // NESTED 外层回滚，内层也回滚
//        serviceB.methodB3();
//        throw new RuntimeException();
        // NESTED 如果只是内层回滚，不影响外层。
//        try {
//            serviceB.methodB4();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        methodTestMapper.insertTest("methodA3");
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void methodA4() {
        methodTestMapper.insertTest("methodA4");
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void methodA5() {
        methodTestMapper.insertTest("methodA4");
        serviceB.methodB2();
        serviceB.methodB3();
    }
}
