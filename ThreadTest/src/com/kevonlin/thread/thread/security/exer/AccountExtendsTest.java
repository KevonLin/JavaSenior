package com.kevonlin.thread.thread.security.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午7:08
 * @description TODO
 */
public class AccountExtendsTest {
    public static void main(String[] args) {
        AccountE p1 = AccountE.getAccount();
        AccountE p2 = AccountE.getAccount();
        p1.start();
        p2.start();
    }
}

class AccountE extends Thread {

    private static double balance;
    private static AccountE ac = null;
    private static ReentrantLock lock = new ReentrantLock();

    private AccountE() {
    }

    public static AccountE getAccount() {
        if (ac == null) {
            synchronized (AccountE.class) {
                if (ac == null) {
                    ac = new AccountE();
                }
            }
        }
        return ac;
    }

    public void deposit(double addBalance) {
        balance += addBalance;
        System.out.println("存款成功");
    }

    public static double getBalance() {
        return balance;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                sleep(100);
                deposit(1000.0);
                System.out.println("当前余额为:" + getBalance());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
