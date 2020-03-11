package com.rainish.adapter;

public class Test {


    public static void main(String[] args) {
        LoginAdapter loginAdapter = new LoginAdapter(new QQLogin());
        loginAdapter.login("test2","test3");

        LoginAdapter loginAdapter1 = new LoginAdapter(new WeixinLogin());
        loginAdapter1.login("test2","test3");
    }
}
