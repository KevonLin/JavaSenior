package com.kevonlin.thread.thread.security.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午4:23
 * @description TODO
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable {

    private int ticket = 100;
    // 1.实例化一个锁
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                // 2.锁上
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "售出 " + ticket + " 号票");
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 3.解锁
                lock.unlock();
            }
        }
    }
}
