package com.kevonlin.thread.java;

import java.lang.management.ThreadInfo;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 上午7:06
 * @description 继承方式创建多线程
 * 常用方法
 * join()
 * yield()
 * sleep()
 * setPriority()
 * getPriority()
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        System.out.println("t1优先级" + t1.getPriority());
        System.out.println("t2优先级" + t2.getPriority());
        System.out.println("main优先级" + Thread.currentThread().getPriority());
        String t1Name = t1.getName();
        System.out.println("t1初始名字：" + t1Name);
        t1.setName("线程1");
        System.out.println("t1修改后的名字：" + t1.getName());
        t1.start();
        t2.setName("线程2");
        t2.start();
        Thread.currentThread().setName("Main");
        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
            if (i == 20) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (i == 40) {
                t1.yield();
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if ((i % 2) == 0) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
            if (i == 20) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
