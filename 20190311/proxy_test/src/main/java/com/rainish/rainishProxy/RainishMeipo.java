package com.rainish.rainishProxy;

import java.lang.reflect.Method;

/**
 * @Author jiajiao
 * @Date 2019/7/5 16:58
 */
public class RainishMeipo implements RainishInvocationHandler{

    private Person person;

    public Object getInstance(Person person){
        this.person = person;
        Class<?> clazz = person.getClass();
//        return RainishProxy.newProxyInstance(new RainishClassLoader(),clazz,this);
        return null;
    }

    @Override
    public Object invoke(Object var1, Method var2, Object[] var3) throws Throwable {
        return null;
    }
}
