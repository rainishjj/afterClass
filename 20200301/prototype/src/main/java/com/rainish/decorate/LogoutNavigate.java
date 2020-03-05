package com.rainish.decorate;

public class LogoutNavigate implements Navigate {
    @Override
    public void printContent() {
        System.out.println("导航内容:问答，文章，精品课，冒泡，商城" );
    }
}
