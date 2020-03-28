package com.rainish.lock;

import com.sun.xml.internal.bind.v2.runtime.SwaRefAdapter;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    private static int i;
    private static Node prev;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("锁住的共享资源");
        System.out.println(i+","+prev);
        lock.unlock();

        ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock1.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock1.writeLock();
        readLock.lock();
        writeLock.lock();
    }
    class Node{
        private int state;
    }
}
