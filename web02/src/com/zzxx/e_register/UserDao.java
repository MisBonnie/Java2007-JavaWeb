package com.zzxx.e_register;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public void insertUser(User user) {
        // 2.将数据保存到数据库中
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "insert into user values(null, ?,?,?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getRealname(), user.getGender(), user.getBirthday());
    }
}
