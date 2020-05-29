package com.rainish.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueTest {
    public static void main(String[] args) {
        RainishQueue rainishQueue = new RainishQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<4;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rainishQueue.put(new Object());
                }
            });
        }
        for(int i=0;i<4;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rainishQueue.take();
                }
            });
        }

        //加这个睡眠时间，是延长主线程的执行时间，等待其他线程执行结束
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束后，queue列队里的大小："+rainishQueue.getQueueSize());
        executorService.shutdown();
    }
}
