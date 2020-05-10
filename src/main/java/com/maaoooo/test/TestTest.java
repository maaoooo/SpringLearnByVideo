package com.maaoooo.test;

import com.maaoooo.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:ApplicationContext.xml")
public class TestTest {
    @Resource(name = "userService")
    private UserService us;
    @org.junit.Test
    public void test1() {
        us.find();
    }
}