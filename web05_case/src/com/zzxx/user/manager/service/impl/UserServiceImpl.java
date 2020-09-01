package com.zzxx.user.manager.service.impl;

import com.zzxx.user.manager.dao.UserDao;
import com.zzxx.user.manager.dao.impl.UserDaoImpl;
import com.zzxx.user.manager.entity.User;
import com.zzxx.user.manager.service.UserService;
import com.zzxx.user.manager.utils.LoginException;
import com.zzxx.user.manager.utils.PageBean;

import java.util.List;
import java.util.Map;

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

    @Override
    public void deleteUserById(int id) {
        ud.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public User findUserById(int id) {
        return ud.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        ud.updateUser(user);
    }

    @Override
    public void deleteSelectedUser(String[] ids) {
        for (String _id : ids) {
            int id = Integer.parseInt(_id);
            ud.deleteById(id);
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _pageSize, Map<String, String[]> condition) {
        // 1.将数据类型转换
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 2.按照当前页数查询List<User>
        //   select * from user limit ?,?
        List<User> list = ud.findUserByPage((currentPage - 1) * pageSize, pageSize, condition);
        // 3.查询总记录条数
        int totalCount = ud.findTotalCount(condition);
        // 4.计算totalPage
//        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        int totalPage = (totalCount + pageSize - 1) / pageSize;

        // 5.封装完整的PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setList(list);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
