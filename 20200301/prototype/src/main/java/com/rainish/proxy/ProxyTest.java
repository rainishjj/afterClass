package com.rainish.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) throws IOException {

        IPerson person = new ZhanShan();
        MeipoProxy meipoProxy = new MeipoProxy(person);
        /**
         * classLoader:第一个参数是被代理对象的ClassLoader
         * interfaces:被代理对象的所有接口
         * invocationHandler: 实现了InvocationHandler的类实例
         * 这个方法返回值是被代理对象
         */
        person = (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(),person.getClass().getInterfaces(),meipoProxy);
        person.findLove();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{IPerson.class});
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\rainish\\workspace\\afterClass\\20200301\\prototype\\$Proxy0.class");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}
