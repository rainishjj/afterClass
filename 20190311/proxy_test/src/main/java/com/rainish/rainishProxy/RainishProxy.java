package com.rainish.rainishProxy;

import java.lang.reflect.InvocationHandler;

/**
 * @Author jiajiao
 * @Date 2019/7/5 16:55
 */
public class RainishProxy {

    public static final String in = "\n";

    public static Object newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler invocationHandler) throws IllegalArgumentException{
        try{
            String src = generateSrc(interfaces);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.rainish.rainishProxy;" + in);
    }
}
