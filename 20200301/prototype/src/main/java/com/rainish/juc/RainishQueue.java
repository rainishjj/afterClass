package com.rainish.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用arrayList来充当队列的数据结构。即是线性结构，不是链表。其中会有扩容的问题，即arrayList是个无限数组，不会存在满的情况。
 * 要实现阻塞队列，则需要控制其大小，不允许进行扩容。所以在判断size的时候，需要加上volatile关键字，让其可见
 *
 * 阻塞队列的特性：队列空了，取数据的线程等待；队列满了，放元素的线程等待
 *
 */
public class RainishQueue {
    private int maxSize = 2;
    private volatile List list = new ArrayList(maxSize);

    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionObjectput = lock.newCondition();
    private Condition conditionObjecttake = lock.newCondition();

    /**
     * 入队
     */
    public void put(Object object){
        lock.lock();
        try {
            if (list.size() == maxSize) {
                try {
                    System.out.println("队列满了"+maxSize+"，线程：" + Thread.currentThread().getName() + "等待");
                    conditionObjectput.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //队列满了，线程需要阻塞
            }
            list.add(object);
            System.out.println("添加元素成功，唤醒所有等待的take线程");
            conditionObjecttake.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 出队
     * @return
     */
    public Object take(){
        lock.lock();
        try{
            if (list.isEmpty()) {
                //线程需要阻塞
                System.out.println("队列为empty线程：" + Thread.currentThread().getName() + "等待");
//                this.wait();
                conditionObjecttake.await();
            }
            Object object = list.get(list.size() - 1);  //取最后一个元素
            list.remove(object);
            System.out.println("获取元素成功，唤醒等待的put线程");
            conditionObjectput.signal();
//            this.notifyAll();
            return object;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }
    public int getQueueSize(){
        return this.list.size();
    }
}
