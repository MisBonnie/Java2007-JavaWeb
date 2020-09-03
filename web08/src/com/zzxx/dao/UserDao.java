package com.zzxx.dao;

import com.zzxx.entity.User;

public interface UserDao {

    User findUserByUsername(String username);
}
