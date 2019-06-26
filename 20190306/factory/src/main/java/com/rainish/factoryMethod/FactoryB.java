package com.rainish.factoryMethod;

import com.rainish.simpleFactory.IProduct;
import com.rainish.simpleFactory.ProductB;

/**
 * @Author jiajiao
 * @Date 2019/6/26 13:27
 */
public class FactoryB implements IFactory {
    @Override
    public IProduct createProduct() {
        return new ProductB();
    }
}
