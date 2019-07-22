package org.sharebook.service;

import org.sharebook.model.User;

public interface UserService {

    boolean login(User user);

    boolean register(User user);

    boolean modify(User user);
}
