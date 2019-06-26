package com.rainish.abstractFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 14:51
 */
public class AbstractFactoryA implements AbstractFactory {

    @Override
    public IProduct1 create1() {
        return new ProductA1();
    }

    @Override
    public IProduct2 create2() {
        return new ProductA2();
    }
}
