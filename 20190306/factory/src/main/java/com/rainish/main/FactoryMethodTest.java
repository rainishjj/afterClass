package com.rainish.main;

import com.rainish.factoryMethod.FactoryA;
import com.rainish.factoryMethod.FactoryB;
import com.rainish.factoryMethod.IFactory;
import com.rainish.simpleFactory.IProduct;

/**
 * @Author jiajiao
 * @Date 2019/6/26 11:03
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        IFactory factory = new FactoryB();
        IProduct product = factory.createProduct();
        product.producer();
    }
}
