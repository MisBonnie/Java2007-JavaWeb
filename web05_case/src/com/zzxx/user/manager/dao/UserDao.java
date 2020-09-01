package com.zzxx.user.manager.dao;

import com.zzxx.user.manager.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User findUserByNameAndPassword(String name, String password);

    List<User> selectAllUsers();

    void deleteById(int id);

    void addUser(User user);

    User findUserById(int id);

    void updateUser(User user);

    List<User> findUserByPage(int start, int pageSize, Map<String, String[]> condition);

    int findTotalCount(Map<String, String[]> condition);
}
