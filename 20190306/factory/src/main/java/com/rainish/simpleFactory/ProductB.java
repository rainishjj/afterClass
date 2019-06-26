package com.rainish.simpleFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 10:29
 */
public class ProductB implements IProduct {
    @Override
    public void producer() {
        System.out.println("I am productB");
    }
}
