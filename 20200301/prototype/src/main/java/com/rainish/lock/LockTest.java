package com.rainish.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static int i;
    private static Node prev;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("锁住的共享资源");
        System.out.println(i+","+prev);
        lock.unlock();
    }
    class Node{
        private int state;
    }
}
