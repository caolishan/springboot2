package com.example.springboot2.service;

import com.example.springboot2.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BaseService {
    @Autowired
    private BaseDao baseDao;

    public Map<String, Object> selectOne(String sql, Object... params) {

        return baseDao.selectOne(sql, params);
    }
}
