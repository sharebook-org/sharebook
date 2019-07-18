package org.sharebook.dao;

import org.junit.Assert;
import org.junit.Test;
import org.sharebook.model.User;

public class UserDaoTest {

    private final UserDao userDao = new UserDao();

    @Test
    public void findById() {
        User user = userDao.findById(Long.valueOf(1));
        //打印出user
        System.out.println(user);
        //使用断言判断user是否为空
        Assert.assertNotNull(user);
    }
}