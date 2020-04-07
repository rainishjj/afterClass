package com.rainish.juc.hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("test","testvalue");
    }
}
