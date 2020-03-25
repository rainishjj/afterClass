package com.rainish.observer.gauva;


import com.google.common.eventbus.Subscribe;
import java.util.Observable;

/**
 * 观察者
 */
public class SaveToES  {

    @Subscribe
    public void update(Object arg) {
        System.out.println("当资产发生变化时，我需要同步资产的变化到Elasticsearch");
    }
}
