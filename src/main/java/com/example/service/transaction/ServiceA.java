package com.example.service.transaction;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description A
 *
 * @author chenmj
 * @date 2021-02-18 15:25
 **/
public interface ServiceA {

    void methodA1();

    void methodA2();

    void methodA3();

    void methodA4();

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    void methodA5();
}
