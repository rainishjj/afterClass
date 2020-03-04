package com.rainish.happenBefore;
import java.util.concurrent.TimeUnit;

public class VolatileArrayListTest {
    /**
     * 对于数组本身是可见的，但是对于数组里面的元素，不行
     * 因为volatile的数组只针对数组的引用具有volatile的语义，而不是它的元素
     */
    public static volatile String[] arrayList = {"1","2"};
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            arrayList[0] = "8";
            System.out.println(arrayList[0]);
            System.out.println("数组本身"+ arrayList.toString());
        }).start();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + ":"+arrayList[0]);
            System.out.println(Thread.currentThread().getName()+"数组本身"+ arrayList.toString());
        }).start();
    }
}
