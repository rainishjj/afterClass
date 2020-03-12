package com.rainish.component;

public abstract class SalaryPackage {
    public abstract void show();

    public SalaryPackage(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
