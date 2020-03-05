package com.rainish.decorate;

public class LoginNavigateDecoration implements Navigate {
    private Navigate navigate;
    public LoginNavigateDecoration(Navigate navigate){
        this.navigate = navigate;
    }

    @Override
    public void printContent() {
        navigate.printContent();
        System.out.println("作业，题库");
    }
}
