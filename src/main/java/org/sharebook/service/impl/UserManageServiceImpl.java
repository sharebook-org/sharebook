package org.sharebook.service.impl;

import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.UserManageService;

import java.util.List;

public class UserManageServiceImpl implements UserManageService {
    UserRepository userRepository;

    // private final UserRepository repository = new UserRepository();

    //构造函数实例化
    public UserManageServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public List<User> getAllUsers(int page, int size) {
        List<User> users = userRepository.findAll(page, size);
        return users;
    }

    @Override
    public int updateRole(long id, int role) {
        User user = userRepository.findById(id);
        user.setRole(role);
        int result = userRepository.update(user);
        return result;
    }

    @Override
    public int updateStatus(long id, int status) {
        User user = userRepository.findById(id);
        user.setStatus(status);
        int result = userRepository.update(user);
        return result;
    }

    @Override
    public int deleteUser(long id) {
        int result = userRepository.delete(id);
        return result;
    }
}
