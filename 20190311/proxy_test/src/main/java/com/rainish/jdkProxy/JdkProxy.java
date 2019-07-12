package com.rainish.jdkProxy;

import com.rainish.rainishProxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author jiajiao
 * @Date 2019/7/12 16:45
 */
public class JdkProxy implements InvocationHandler {

    private Person target;

    public JdkProxy(Person target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target,args);
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
