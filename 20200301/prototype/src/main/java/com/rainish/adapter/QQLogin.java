package com.rainish.adapter;

public class QQLogin implements ThirdPartLogin {

    private Account findAccountByOpenId(String openId) {
        Account account = new Account("test","test");
        return account;
    }

    @Override
    public String loginThird(String openId) {
        Account account = findAccountByOpenId(openId);
        if(account != null){
            System.out.println("QQ登录成功");
            return "登录成功";
        }
        return null;
    }
}
