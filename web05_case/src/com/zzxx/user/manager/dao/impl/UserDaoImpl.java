package com.zzxx.user.manager.dao.impl;

import com.zzxx.user.manager.dao.UserDao;
import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public void deleteById(int id) {
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user values(null, ?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getGender(), user.getQq(), user.getEmail(), user.getAddress(), user.getPassword());
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), id);
        return list.size() != 0 ? list.get(0) : null;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?,age=?,gender=?,email=?,address=?,qq=? where id=?";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getGender(), user.getEmail(), user.getAddress(), user.getQq(), user.getId());
    }

    @Override
    public List<User> findUserByPage(int start, int pageSize, Map<String, String[]> condition) {
        StringBuilder _sql = new StringBuilder("select * from user where 1=1 ");
        // 定义一个保存参数值的集合
        List<Object> params = new ArrayList<>();
        // condition: {name=[张], address=[宁], email=[xx]}
        Set<String> keys = condition.keySet();
        for (String key : keys) {
            if (key.equals("name") || key.equals("address") || key.equals("email")) {
                // sql拼接name的条件
                _sql.append(" and "+key+" like ? ");
                String value=condition.get(key)[0];
                params.add("%" + value + "%");
            }
        }
        // 继续拼接分页limit条件
        _sql.append(" limit ?, ?");
        // 继续添加分页的参数
        params.add(start);
        params.add(pageSize);
        List<User> list = jdbcTemplate.query(_sql.toString(), new BeanPropertyRowMapper<>(User.class), params.toArray());
        return list;
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        StringBuilder _sql = new StringBuilder("select count(*) from user where 1=1");

        // 定义一个保存参数值的集合
        List<Object> params = new ArrayList<>();
        // condition: {name=[张], address=[宁], email=[xx]}
        Set<String> keys = condition.keySet();
        for (String key : keys) {
            if (key.equals("name") || key.equals("address") || key.equals("email")) {
                // sql拼接name的条件
                _sql.append(" and "+key+" like ? ");
                String value=condition.get(key)[0];
                params.add("%" + value + "%");
            }
        }

        Integer count = jdbcTemplate.queryForObject(_sql.toString(), Integer.class, params.toArray());
        return count;
    }
}
