package com.zzxx.user.manager.service.impl;

import com.zzxx.user.manager.dao.UserDao;
import com.zzxx.user.manager.dao.impl.UserDaoImpl;
import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.utils.LoginException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    @Override
    public User login(User user) throws LoginException {
        // 1.查找数据库

        User loginUser = ud.findUserByNameAndPassword(user.getName(), user.getPassword());
        // 2.对结果判断
        if (loginUser != null) {
            return loginUser;
        } else {
            throw new LoginException("用户名/密码错误!");
        }
    }

    @Override
    public List<User> findAll() {
        // 调用 UserDao 的方法, 将结果返回
        List<User> list = ud.selectAllUsers();
        return list;
    }
}
