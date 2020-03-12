package com.rainish.component;

public class Test {
    public static void main(String[] args) {

        SalarySystem salarySystem = new SalarySystem("正式员工体系",1);
        SalarySystem salarySystem1 = new SalarySystem("成都分公司体系",2);
        Item item = new Item("工资科目");
        salarySystem.add(item);
        salarySystem.add(salarySystem1);
        salarySystem.show();
    }
}
