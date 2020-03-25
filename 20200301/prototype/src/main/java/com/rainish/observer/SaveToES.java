package com.rainish.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class SaveToES implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("当资产发生变化时，我需要同步资产的变化到Elasticsearch");
    }
}
