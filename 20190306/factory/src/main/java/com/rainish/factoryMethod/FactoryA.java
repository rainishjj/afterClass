package com.rainish.factoryMethod;

import com.rainish.simpleFactory.IProduct;
import com.rainish.simpleFactory.ProductA;

/**
 * @Author jiajiao
 * @Date 2019/6/26 11:02
 */
public class FactoryA implements IFactory {
    @Override
    public IProduct createProduct() {
        return new ProductA();
    }
}
