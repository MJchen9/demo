package com.example.service.transaction;

import com.example.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class ServiceATest {

    @Autowired
    ServiceA serviceA;

    @Test
    public void methodA1() {
        serviceA.methodA1();
    }

    @Test
    public void methodA2() {
        serviceA.methodA2();
    }

    @Test
    public void methodA3() {
        serviceA.methodA3();
    }

    @Test
    public void methodA4() {
        serviceA.methodA4();
    }

    @Test
    public void methodA5() {
        serviceA.methodA5();
    }
}