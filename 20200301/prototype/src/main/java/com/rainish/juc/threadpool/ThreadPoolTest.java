package com.rainish.juc.threadpool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(1);
        ExecutorService executorService = new ThreadPoolExecutor(2,2,0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        for(int i=0;i<4;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("test");
                }
            });
        }
    }
}
