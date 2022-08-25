package com.kevonlin.thread.thread.security.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午4:36
 * @description lock解决懒汉式线程安全问题
 */
public class LockSingleton {
    public static void main(String[] args) {
        MyBank instance1 = MyBank.getInstance();
        MyBank instance2 = MyBank.getInstance();
        System.out.println(instance1 == instance2);
    }
}

class MyBank {

    private static MyBank bank = null;
    private static ReentrantLock lock = new ReentrantLock(true);

    private MyBank() {
    }

    public static MyBank getInstance() {
        if (bank == null) {
            try {
                lock.lock();
                if (bank == null) {
                    bank = new MyBank();
                }
            } finally {
                lock.unlock();
            }
        }
        return bank;
    }
}