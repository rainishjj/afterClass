package com.rainish.decorate;

public class DecorationTest {
    public static void main(String[] args) {
        LogoutNavigate logoutNavigate = new LogoutNavigate();
        LoginNavigateDecoration loginNavigateDecoration = new LoginNavigateDecoration(logoutNavigate);
        LoginNavigateDecoration loginNavigateDecoration1 = new LoginNavigateDecoration(loginNavigateDecoration);
        loginNavigateDecoration1.printContent();
    }
}
