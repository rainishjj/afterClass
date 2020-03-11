package com.rainish.adapter;

public class InternLogin implements Login {
    @Override
    public String login(String username, String password) {
        return "用户名密码验证成功";
    }
}
