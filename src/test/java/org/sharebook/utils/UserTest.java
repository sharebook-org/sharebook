package org.sharebook.utils;

import org.junit.Test;
import org.sharebook.model.User;
import org.sharebook.repository.impl.UserRepositoryImpl;

import java.util.List;

public class UserTest {
    @Test
    public void findAllUsers(){
        UserRepositoryImpl userRepository=new UserRepositoryImpl();
        List<User> users= userRepository.findAllUsers(1,2);
        System.out.println(users);
    }

    @Test
    public void getUsersCount(){
        UserRepositoryImpl userRepository=new UserRepositoryImpl();
        System.out.println(userRepository.getUsersCount());
    }
}
