package org.sharebook.service.impl;

import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    UserRepository userRepository;

    // private final UserRepository repository = new UserRepository();

    //构造函数实例化
    public AdminServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> getAllUsers(int page, int size) {
        List<User> users = userRepository.findAll(page, size);
        if (users!=null){
            return users;
        }
        return null;
    }
}
