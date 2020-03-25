package com.rainish.observer.gauva;

import com.google.common.eventbus.EventBus;

import java.util.Observable;

public class Asset extends EventBus {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
