package com.example.springboot2.Impl;

import com.example.springboot2.ISpiProvider;

import java.util.HashMap;
import java.util.Map;

public class SPITest {
    public static void main(String[] args) {
        ISpiProvider iSpiProvider = ISpiProviderFactory.newISpiProvider();
       final Map<Object,Object> map = new HashMap<>();
        map.put("key1","service provider interface1");
        iSpiProvider.exec(map);
    }
}
