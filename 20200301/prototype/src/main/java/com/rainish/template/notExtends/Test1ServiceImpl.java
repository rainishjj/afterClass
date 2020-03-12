package com.rainish.template.notExtends;

public class Test1ServiceImpl implements TestService {

    public void afterSaveOrUpdate() {
        System.out.println("这是test1的后续处理");
    }
}
