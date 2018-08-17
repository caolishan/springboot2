package com.example.springboot2.spi;

import com.example.springboot2.spi.Impl.SpiSerivceFactory;

public class SpiTest {
    public static void main(String[] args) {
        SpiSerivce spiSerivce = SpiSerivceFactory.newSpiServivce();
        spiSerivce.exec("hello spi I am Jack Ma");
    }
}
