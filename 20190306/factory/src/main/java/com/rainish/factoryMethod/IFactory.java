package com.rainish.factoryMethod;

import com.rainish.simpleFactory.IProduct;

/**
 * @Author jiajiao
 * @Date 2019/6/26 11:01
 */
public interface IFactory {
    IProduct createProduct();
}
