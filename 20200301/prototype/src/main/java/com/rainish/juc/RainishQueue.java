package com.rainish.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
        try {
            lock.lock();
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
        try{
            lock.lock();
            if (list.isEmpty()) {
                //线程需要阻塞
                System.out.println("队列为empty线程：" + Thread.currentThread().getName() + "等待");
                conditionObjecttake.await();
            }
            Object object = list.get(list.size() - 1);  //取最后一个元素
            list.remove(object);
            System.out.println("获取元素成功，唤醒等待的put线程");
            conditionObjectput.signal();
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
