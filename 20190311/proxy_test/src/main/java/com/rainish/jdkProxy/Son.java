package com.rainish.jdkProxy;

import com.rainish.rainishProxy.Person;

/**
 * @Author jiajiao
 * @Date 2019/7/12 16:44
 */
public class Son implements Person {
    @Override
    public String findLove() {
        System.out.println("肤白貌美大长腿");
        return null;
    }
}
