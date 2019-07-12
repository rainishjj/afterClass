package com.rainish.jdkProxy;

import com.rainish.rainishProxy.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

/**
 * @Author jiajiao
 * @Date 2019/7/12 16:51
 */
public class JdkProxyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {


        JdkProxy jdkProxy1 = new JdkProxy(new Girl());
        Person proxy1 = (Person) jdkProxy1.getInstance();
        proxy1.findLove();

        Person person = new Girl();
        Person proxy = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new JdkProxy(person));
        proxy.findLove();
        byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
        os.write(bytes);
        os.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
