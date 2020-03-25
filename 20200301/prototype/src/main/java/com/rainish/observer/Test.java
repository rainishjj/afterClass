package com.rainish.observer;

public class Test {
    public static void main(String[] args) {
        SaveToES saveToES = new SaveToES();
        Asset asset = new Asset();
        asset.addObserver(saveToES);
        asset.setName("test");
    }
}
