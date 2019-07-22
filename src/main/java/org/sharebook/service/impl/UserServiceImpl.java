package org.sharebook.service.impl;

import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean register(User user) {
        int result = userRepository.save(user);
        return false;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }
}
