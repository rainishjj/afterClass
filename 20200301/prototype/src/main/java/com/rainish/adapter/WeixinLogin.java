package com.rainish.adapter;

public class WeixinLogin implements ThirdPartLogin {

    @Override
    public String loginThird(String openId) {
        Account account = findAccountByOpenId(openId);
        if(account != null){
            System.out.println("微信登录成功");
            return "登录成功";
        }
        return null;
    }

    private Account findAccountByOpenId(String openId) {
        Account account = new Account("test","test");
        return account;
    }
}
