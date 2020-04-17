package com.rainish.java.polymorphism;

public class Test {
    public static void main(String[] args) {
//        RainishServlet rainishServlet = new RainishServlet();
        RainishServlet rainishServlet = new RainishHttpServlet();
        rainishServlet.init();
    }
}
