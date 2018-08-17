package com.example.springboot2.Impl;

import com.example.springboot2.ISpiProvider;

import java.util.HashMap;
import java.util.Map;

public class ISpiProviderImpl implements ISpiProvider {
    @Override
    public Object exec(final  Map<Object, Object> paraMap) {
        paraMap.put("key2","service provider interface2");
        System.out.println(paraMap.toString());

        return paraMap;
    }
}
