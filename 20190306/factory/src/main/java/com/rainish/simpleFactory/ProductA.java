package com.rainish.simpleFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 10:28
 */
public class ProductA implements IProduct {
    @Override
    public void producer() {
        System.out.println("I am Product A");
    }
}
