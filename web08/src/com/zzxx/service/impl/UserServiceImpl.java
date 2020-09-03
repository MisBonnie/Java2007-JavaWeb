package com.zzxx.service.impl;

import com.zzxx.dao.UserDao;
import com.zzxx.dao.impl.UserDaoImpl;
import com.zzxx.entity.User;
import com.zzxx.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean checkUser(String username) {
        UserDao ud = new UserDaoImpl();
        User user = ud.findUserByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }
}
