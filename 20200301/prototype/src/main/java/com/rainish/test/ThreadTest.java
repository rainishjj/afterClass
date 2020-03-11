package com.rainish.test;

import com.rainish.adapter.Account;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(() ->{
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程1输出");
            Account account = new Account("test1","pws1");
            test(account);
        }).start();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "线程2输出");
            Account account = new Account("test2","pws2");
            test(account);
        }).start();


    }

    private static String test(Account account){
        System.out.println(Thread.currentThread().getName() + ":" + account);
        System.out.println(Thread.currentThread().getName() + "用户名" + account.getUsername());
        return null;
    }
}
