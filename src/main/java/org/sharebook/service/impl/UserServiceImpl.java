package org.sharebook.service.impl;

import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.UserService;
import org.sharebook.utils.MD5Utils;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User u = userRepository.findByUsername(username);
        System.out.println(u);
        if (user != null) {
            String salt = u.getSalt();
            String encryptPassword = MD5Utils.md5(password, salt);
            if (encryptPassword.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        boolean isExist = isExistUser(user.getUsername());
        if (!isExist) {
            String salt = MD5Utils.getSalt();
            String encryptPassword = MD5Utils.md5(
                    user.getPassword(), salt
            );
            user.setSalt(salt);
            user.setPassword(encryptPassword);
            int result = userRepository.save(user);
            if (result > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }

    @Override
    public boolean isExistUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }
}
