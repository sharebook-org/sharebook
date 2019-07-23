package org.sharebook.repository.impl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.sharebook.constant.Sex;
import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;

import java.util.Date;

//指定测试执行顺序为代码定义方法的顺序执行
@FixMethodOrder(MethodSorters.JVM)
public class UserRepositoryImplTest {

    private final UserRepository userRepository = new UserRepositoryImpl();

    private User user = new User(Long.valueOf(1), "test", "pwd",
            "abcd", "xx", 1, new Date(), "中国",
            0, 0, "https://baidu.com", new Date(), new Date());

    @Test
    public void findById() {
        User user = userRepository.findById(Long.valueOf(1));
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void save() {
        int result = userRepository.save(user);
        System.out.println("save result:" + result);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByUsername() {
        User user = userRepository.findByUsername("czq");
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void update() {
        User newUser = user;
        newUser.setIntroduction("xxxxaaa");
        newUser.setSex(Sex.OTHER);
        int result = userRepository.update(newUser);
        System.out.println(result);
        Assert.assertEquals(1, result);
    }

    @Test
    public void delete() {
        int result = userRepository.delete(Long.valueOf(1));
        System.out.println(result);
        Assert.assertEquals(1, result);
    }


}