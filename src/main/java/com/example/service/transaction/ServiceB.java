package com.example.service.transaction;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description B
 *
 * @author chenmj
 * @date 2021-02-18 15:25
 **/
public interface ServiceB {

    void methodB1();

    void methodB2();

    void methodB5();

    void methodB3();

    void methodB4();
}
