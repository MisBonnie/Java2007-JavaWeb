package com.zzxx.user.manager.dao.impl;

import com.zzxx.user.manager.dao.UserDao;
import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public User findUserByNameAndPassword(String name, String password) {
        String sql = "select * from user where name = ? and password=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), name, password);
        return list.size() == 0 ? null : list.get(0);
    }

    @Override
    public List<User> selectAllUsers() {
        String sql = "select * from user";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }
}
