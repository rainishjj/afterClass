package com.rainish.observer.gauva;

public class Test {
    public static void main(String[] args) {
        SaveToES saveToES = new SaveToES();
        Asset asset = new Asset();
        asset.register(saveToES);
        asset.setName("test");
        asset.post(saveToES);
    }
}
