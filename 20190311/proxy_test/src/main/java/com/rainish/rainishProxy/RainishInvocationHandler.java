package com.rainish.rainishProxy;

import java.lang.reflect.Method;

/**
 * @Author jiajiao
 * @Date 2019/7/5 16:53
 */
public interface RainishInvocationHandler {
    Object invoke(Object var1, Method var2, Object[] var3) throws Throwable;
}
