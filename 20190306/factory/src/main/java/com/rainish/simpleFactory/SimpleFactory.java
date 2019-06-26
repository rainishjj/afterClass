package com.rainish.simpleFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 10:25
 */
public class SimpleFactory {
    public IProduct createProduct(String name){
        if("productA".equals(name)){
            return new ProductA();
        }else if("productB".equals(name)){
            return new ProductB();
        }else {
            return null;
        }
    }
}
