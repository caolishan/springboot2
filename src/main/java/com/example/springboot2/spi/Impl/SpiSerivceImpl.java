package com.example.springboot2.spi.Impl;

import com.example.springboot2.spi.SpiSerivce;

public class SpiSerivceImpl implements SpiSerivce {

    @Override
    public Object exec(Object obj) {
        System.out.println(String.valueOf(obj));
        return obj;
    }

}
