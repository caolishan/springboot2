package com.example.springboot2.spi.Impl;

import com.example.springboot2.spi.SpiSerivce;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiSerivceFactory {
    private SpiSerivceFactory(){}

    public static SpiSerivce newSpiServivce(){
        SpiSerivce spiSerivce =null;
        ServiceLoader<SpiSerivce> load = ServiceLoader.load(SpiSerivce.class);
        Iterator<SpiSerivce> iterator = load.iterator();
        while (iterator.hasNext()){
            spiSerivce=iterator.next();
        }
        return spiSerivce;
    }
}
