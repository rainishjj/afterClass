package com.rainish.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeipoProxy implements IPerson,InvocationHandler{
    IPerson iPerson;
    public MeipoProxy(IPerson person){
        this.iPerson = person;

    }

    /**
     * Proxy:被代理对象
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(iPerson,args);
    }

    @Override
    public void findLove() {
        this.iPerson.findLove();
    }
}
