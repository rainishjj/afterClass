package com.rainish.lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {
    private static int date;

    public static int getDate() {
        return date;
    }

    public static void setDate(int date) {
        date = date;
    }

    public static void main(String[] args) {
//        ReentrantLock lock = new ReentrantLock();
//        new Thread(() -> {
//            System.out.println(Thread.currentThread().getName() + ":" + getDate());
//        }).start();
//
//        new Thread(() -> {
//            lock.lock();
//            date++;
//            lock.unlock();
//            System.out.println(Thread.currentThread().getName() + ":" + getDate());
//        }).start();
//
//        new Thread(() -> {
//            lock.lock();
//            date++;
//            lock.unlock();
//            System.out.println(Thread.currentThread().getName() + ":" + getDate());
//        }).start();
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        new Thread(()->{
            readLock.lock();
            readLock.unlock();
        }).start();

        new Thread(()->{
            readLock.lock();
            readLock.unlock();
        }).start();

        new Thread(()->{
            writeLock.lock();
            writeLock.unlock();
        }).start();


    }
}
