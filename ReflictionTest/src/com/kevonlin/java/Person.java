package com.kevonlin.java;

/**
 * @author KevonLin
 * @version 1.0
 * @description Person
 * @date 2022/9/20 13:13
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
        this.age = age;
    }

    Person(String name) {
        this.name = name;
    }

    private void show(String nation){
        System.out.println("我的国籍是:" + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
