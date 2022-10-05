package com.kevonlin.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KevonLin
 * @version 1.0
 * @description TODO
 * @date 2022/10/5 17:28
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云", 12, 7243.23));
        list.add(new Employee(1003, "雷军", 34, 3412.34));
        list.add(new Employee(1004, "刘强东", 34, 6634.13));
        return list;
    }
}
