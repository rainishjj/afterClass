package com.rainish.main;

import com.rainish.factoryMethod.FactoryA;
import com.rainish.factoryMethod.IFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 11:03
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        factory.createProduct();
    }
}
