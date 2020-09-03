package com.zzxx.dao.impl;

import com.zzxx.dao.UserDao;
import com.zzxx.entity.User;
import com.zzxx.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    @Override
    public User findUserByUsername(String username) {
        String sql = "select * from user where name = ?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), username);
        return list.size() == 0 ? null:list.get(0);
    }
}
