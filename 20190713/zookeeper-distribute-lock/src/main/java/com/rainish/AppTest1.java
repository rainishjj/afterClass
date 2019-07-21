package com.rainish;

import java.io.IOException;

/**
 * @Author jiajiao
 * @Date 2019/7/19 13:09
 */
public class AppTest1 {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            RainishLock rainishLock = new RainishLock();
            rainishLock.lock();
        }).start();
        System.in.read();

//        new Thread(() -> {
//            RainishLock rainishLock = new RainishLock();
//            rainishLock.lock();
//        }).start();
//
//        new Thread(() -> {
//            RainishLock rainishLock = new RainishLock();
//            rainishLock.lock();
//        }).start();
    }
}
