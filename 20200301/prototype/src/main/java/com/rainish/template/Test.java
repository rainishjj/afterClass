package com.rainish.template;

public class Test {
    public static void main(String[] args) {
        ServiceTemplate serviceTemplate = new Test1ServiceImpl();
        serviceTemplate.saveOrUpdate(null);
    }
}
