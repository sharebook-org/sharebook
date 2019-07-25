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
        if (users != null) {
            return users;
        }
        return null;
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
