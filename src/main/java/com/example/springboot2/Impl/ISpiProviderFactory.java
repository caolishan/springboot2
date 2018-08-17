package com.example.springboot2.Impl;

import com.example.springboot2.ISpiProvider;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ISpiProviderFactory {
    private ISpiProviderFactory(){

    }

    public static ISpiProvider newISpiProvider(){
        ISpiProvider iSpiProvider=null;
        ServiceLoader<ISpiProvider> loader = ServiceLoader.load(ISpiProvider.class);
        Iterator<ISpiProvider> iterator = loader.iterator();
        while (iterator.hasNext()){
            iSpiProvider = iterator.next();
        }
        return iSpiProvider;
    }
}
