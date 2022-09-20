package com.keovnlin.java;

import java.util.Objects;

/**
 * @author KevonLin
 * @version 1.0
 * @description
 * 定义一个 Employee 类， 该类包含：private 成员变量 name,age,birthday，其中 birthday 为 MyDate 类的 对象；
 * 并为每一个属性定义 getter, setter 方法； 并重写 toString 方法输出 name, age, birthday
 * 1). 使 Employee 继承 Comparable 接口，并按 name 排序
 * @date 2022/9/5 22:43
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareTo(e.name);
    }
}
