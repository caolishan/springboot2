package com.example.springboot2.service;

import com.example.springboot2.dao.UserDao;
import com.example.springboot2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public List<User> queryUsersWithCondi(User user) {
        return userDao.queryUsersWithCondi(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public Map<String, Object> queryUserMapById(Map<String, Object> paramMap) {
        return userDao.queryUserMapById(paramMap);
    }

    public Map<String, Object> selectOne(Map<String, Object> paramMap) {
        String sql = "select * from user where id = 1";
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        return selectOne(sql, null);
    }

    @Override
    public int deleteAll(List<User> userList) {
        return userDao.deleteAll(userList);
    }

    @Override
    public int insertAll(List<User> userList) {
        return userDao.insertAll(userList);
    }


}
