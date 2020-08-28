package com.zzxx.user.manager.service;

import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.utils.LoginException;

import java.util.List;

public interface UserService {
    User login(User user) throws LoginException;

    List<User> findAll();
}
