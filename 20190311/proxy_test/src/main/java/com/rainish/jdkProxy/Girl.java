package com.rainish.jdkProxy;

import com.rainish.rainishProxy.Person;

/**
 * @Author jiajiao
 * @Date 2019/7/12 16:53
 */
public class Girl implements Person {
    @Override
    public String findLove() {
        System.out.println("高富帅");
        return null;
    }
}
