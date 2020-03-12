package com.rainish.template.notExtends;

public class Test {
    public static void main(String[] args) {
        ServiceTemplate serviceTemplate = new ServiceTemplate(new Test1ServiceImpl());
        serviceTemplate.saveOrUpdate(null);
    }
}
