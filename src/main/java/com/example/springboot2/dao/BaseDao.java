package com.example.springboot2.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public <T> T selectOne(String sql, Object[] params) {
       return sqlSessionTemplate.selectOne(sql,params);
    }
}
