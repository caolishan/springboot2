package com.example.springboot2.service;

import com.example.springboot2.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UserService {
    int add(User user);
    User queryUserById(int id);
    List<User> queryUsersWithCondi(User user);
    @Transactional
    int update(User user);
    @Transactional
    int delete(User user);

    Map<String,Object> queryUserMapById(Map<String,Object> paramMap);

    Map<String, Object> selectOne(Map<String, Object> paramMap);

    int deleteAll(List<User> userList);

    int insertAll(List<User> userList);
}
