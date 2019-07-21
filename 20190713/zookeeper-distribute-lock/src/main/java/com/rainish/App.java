package com.rainish;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        new Thread(() -> {
            RainishLock rainishLock = new RainishLock();
            rainishLock.lock();
        }).start();
//        System.in.read();

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
