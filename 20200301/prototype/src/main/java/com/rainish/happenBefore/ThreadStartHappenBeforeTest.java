package com.rainish.happenBefore;

/**
 * 线程start规则 happens-before的其中一种规则
 */
public class ThreadStartHappenBeforeTest {
    static int x =0;
    public static void main(String[] args) {
        new Thread(()-> {
            int b = x; //这里的x一定是200
            System.out.printf("b" + b);
        }).start();
        x = 200;
    }
}
