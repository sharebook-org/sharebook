package org.sharebook.service.impl;

import org.sharebook.constant.status.ActiveStatus;
import org.sharebook.constant.status.UserStatus;
import org.sharebook.model.Active;
import org.sharebook.model.User;
import org.sharebook.repository.ActiveRepository;
import org.sharebook.repository.UserRepository;
import org.sharebook.repository.impl.ActiveRepositoryImpl;
import org.sharebook.repository.impl.UserRepositoryImpl;
import org.sharebook.service.UserService;
import org.sharebook.utils.CodeUtils;
import org.sharebook.utils.MD5Utils;
import org.sharebook.utils.MailUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ActiveRepository activeRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        this.activeRepository = new ActiveRepositoryImpl();
    }

    @Override
    public boolean modify(User user) {
        int result = userRepository.update(user);
        return result != 0;
    }

    @Override
    public User findUserById(Long id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public List<User> findUsers(List<Long> ids) {
        List<User> users = userRepository.findUsers(ids);
        return users;
    }

    @Override
    public User findUserByName(String name) {
        User user = userRepository.findByUsername(name);
        return user;
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
                return encryptPassword.equals(u.getPassword());
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
            String code = CodeUtils.generateUniqueCode().substring(0,4);
            String salt = MD5Utils.getSalt();
            String encryptPassword = MD5Utils.md5(
                    user.getPassword(), salt
            );
            user.setSalt(salt);
            user.setPassword(encryptPassword);
            int result2 = userRepository.save(user);
            User user1 = userRepository.findByEmail(user.getEmail());

            //给该用户一个验证码code
            Active active = new Active(user1.getId(), code, ActiveStatus.INACTIVATED);
            int result1 = activeRepository.save(active);
            return result1 > 0 && result2 > 0;
        }
        return false;
    }

    @Override
    public boolean isExistUser(String username) {
        User user = userRepository.findByUsername(username);
        return user != null;
    }

    public boolean isExistUser(User user) {
        User u = userRepository.findByEmail(user.getEmail());
        if (u == null) {
            u = userRepository.findByPhone(user.getPhone());
        }
        return u != null;
    }

    @Override
    public boolean modifyPassword(User user) {
        int res = userRepository.modifyPassword(user);
        return res > 0;
    }

    @Override
    public boolean checkCode(String email, String code) {
        User user = userRepository.findByEmail(email);
        Active active = activeRepository.findByUserId(user.getId());
        if (code.equals(active.getCode())) {
            active.setStatus(ActiveStatus.ACTIVATED);
            int result = activeRepository.update(active);
            return result > 0;
        }
        return false;
    }

    @Override
    public boolean getCode(String email) {
        User user = userRepository.findByEmail(email);
        Active active = activeRepository.findByUserId(user.getId());
        if (active != null) {
            new Thread(new MailUtils(email, active.getCode())).start();
            return true;
        }
        return false;
    }

    @Override
    public Active findByAccount(String account) {
        User user=userRepository.findByEmail(account);
        if (user == null){
            user=userRepository.findByPhone(account);
        }
        if (user!=null){
            Active active=activeRepository.findByUserId(user.getId());
            return active;
        }
        return null;
    }
}
