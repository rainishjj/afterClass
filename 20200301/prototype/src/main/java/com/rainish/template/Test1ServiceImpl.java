package com.rainish.template;

public class Test1ServiceImpl extends ServiceTemplate {
    @Override
    protected void afterSaveOrUpdate() {
        System.out.println("这是test1的后续处理");
    }
}
