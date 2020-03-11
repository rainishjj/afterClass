package com.rainish.adapter;

public class LoginAdapter implements Login,ThirdPartLogin {

    private ThirdPartLogin login;
    public LoginAdapter(ThirdPartLogin login) {
        this.login = login;
    }

    @Override
    public String login(String username, String password) {
        return login.loginThird(username);
    }

    @Override
    public String loginThird(String openId) {
        return null;
    }
}
