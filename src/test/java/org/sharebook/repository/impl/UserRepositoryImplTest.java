package org.sharebook.repository.impl;

import org.junit.Assert;
import org.junit.Test;
import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;

public class UserRepositoryImplTest {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Test
    public void findById() {
        User user = userRepository.findById(Long.valueOf(1));
        System.out.println(user);
        Assert.assertNotNull(user);
    }
}