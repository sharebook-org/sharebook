package org.sharebook.service.impl;

import org.sharebook.constant.status.UserStatus;
import org.sharebook.model.User;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.UserService;
import org.sharebook.utils.MD5Utils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public boolean modify(User user) {
        int result = userRepository.update(user);
        if (result != 0) {
            return true;
        }
        return false;
    }

    @Override
    public User findUserById(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> findUsers(List<Long> ids) {
        List<User> users = userRepository.findUsers(ids);
        return users;
    }

    @Override
    public User findUserByName(String name) {
        User user = userRepository.findByUsername(name);
        if (user != null) {
            return user;
        }
        return null;
    }

    @Override
    public long getCount() {
        return userRepository.getUsersCount();
    }

    @Override
    public boolean login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User u = userRepository.findByUsername(username);
        if (user != null) {
            if (u.getStatus() == UserStatus.NORMAL) {
                String salt = u.getSalt();
                String encryptPassword = MD5Utils.md5(password, salt);
                if (encryptPassword.equals(u.getPassword())) {
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public User login(String account, String password) {
        User user = userRepository.findByEmail(account);
        if (user == null) {
            user = userRepository.findByPhone(account);
        }
        return user;
    }

    @Override
    public boolean register(User user) {
        boolean isExist = isExistUser(user);
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
    public boolean isExistUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }

    public boolean isExistUser(User user) {
        User u = userRepository.findByEmail(user.getEmail());
        if (u == null) {
            u = userRepository.findByPhone(user.getPhone());
        }
        if (u != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyPassword(User user) {
        int res = userRepository.modifyPassword(user);
        if (res > 0) {
            return true;
        }
        return false;
    }
}
