package com.rainish.component;

import java.util.ArrayList;
import java.util.List;

public class Item extends SalaryPackage {

    public Item(String name) {
        super(name);
    }


    @Override
    public void show() {
        System.out.println("item" + this.getName());
    }
}
