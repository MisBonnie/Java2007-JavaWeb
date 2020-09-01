package com.zzxx.user.manager.service;

import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.utils.LoginException;
import com.zzxx.user.manager.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface UserService {
    User login(User user) throws LoginException;

    List<User> findAll();

    void deleteUserById(int id);

    void addUser(User user);

    User findUserById(int id);

    void updateUser(User user);

    void deleteSelectedUser(String[] ids);

    PageBean<User> findUserByPage(String currentPage, String pageSize, Map<String, String[]> condition);
}
