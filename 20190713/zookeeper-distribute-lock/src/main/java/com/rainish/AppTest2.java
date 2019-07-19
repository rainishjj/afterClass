package com.rainish;

/**
 * @Author jiajiao
 * @Date 2019/7/19 13:09
 */
public class AppTest2 {
    public static void main(String[] args) {
        new Thread(() -> {
            RainishLock rainishLock = new RainishLock();
            rainishLock.lock();
        }).start();

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
