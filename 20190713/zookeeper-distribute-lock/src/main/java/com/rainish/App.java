package com.rainish;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
