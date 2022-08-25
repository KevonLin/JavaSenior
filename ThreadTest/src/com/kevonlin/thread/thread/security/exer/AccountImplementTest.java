package com.kevonlin.thread.thread.security.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午6:34
 * @description TODO
 */
public class AccountImplementTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        Thread p1 = new Thread(account);
        Thread p2 = new Thread(account);
        p1.setName("甲");
        p2.setName("乙");
        p1.start();
        p2.start();
    }
}

class Account implements Runnable {

    private double balance;
    private final ReentrantLock lock = new ReentrantLock(true);

    public Account(double balance) {
        this.balance = balance;
    }

    private void deposit() {
        balance += 1000.0;
        System.out.println(Thread.currentThread().getName() + "存钱成功");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                Thread.sleep(100);
                deposit();
                System.out.println("当前余额为" + balance);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
