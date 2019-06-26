package com.rainish.simpleFactory;

/**
 * @Author jiajiao
 * @Date 2019/6/26 10:25
 */
public class SimpleFactory {

//    // 第一种写法
//    public IProduct createProduct1(String className){
//        if("productA".equals(className)){
//            return new ProductA();
//        }
//        if("productB".equals(className)){
//            return new ProductB();
//        }
//        return null;
//    }

    // 第二种写法
    public IProduct createProduct(String className){
        try {
            Class<?> clazz = Class.forName(className);
            IProduct product = (IProduct)clazz.newInstance();
            return product;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
