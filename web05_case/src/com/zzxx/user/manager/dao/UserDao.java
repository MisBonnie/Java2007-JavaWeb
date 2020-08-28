package com.zzxx.user.manager.dao;

import com.zzxx.user.manager.entity.User;

import java.util.List;

public interface UserDao {
    User findUserByNameAndPassword(String name, String password);

    List<User> selectAllUsers();
}
