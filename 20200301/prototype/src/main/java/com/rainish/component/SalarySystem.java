package com.rainish.component;

import java.util.ArrayList;
import java.util.List;

public class SalarySystem extends SalaryPackage {

    private int level;
    private List<SalaryPackage> list = new ArrayList<>();

    public SalarySystem(String name,int level) {
        super(name);
        this.level = level;
    }

    @Override
    public void show() {
        for (SalaryPackage salaryPackage : list) {
            System.out.println("system" + salaryPackage.getName());
        }

    }

    public void add(SalaryPackage salaryPackage){
        this.list.add(salaryPackage);
    }

}
