package com.kevonlin.thread.thread.security.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午4:14
 * @description TODO
 */
public class SingletonTest {
    public static void main(String[] args) {
        Bank instance1 = Bank.getInstance();
        Bank instance2 = Bank.getInstance();
        System.out.println(instance1 == instance2);
        instance1.setName("Kevon");
        String name = instance2.getName();
        System.out.println(name);
    }
}

class Bank {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    private Bank bank = null;
    private static Bank bank = null;

    private Bank() {
    }

    public static Bank getInstance() {
        if (bank == null) {
            synchronized (Bank.class) {
                if (bank == null) {
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}
