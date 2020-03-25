package com.rainish.observer;

import java.util.Observable;

public class Asset extends Observable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
        this.notifyObservers();
    }
}
