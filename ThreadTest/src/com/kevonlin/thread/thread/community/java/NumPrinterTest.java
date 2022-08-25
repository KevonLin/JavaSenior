package com.kevonlin.thread.thread.community.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午8:22
 * @description 两个线程交替打印1-100
 */
public class NumPrinterTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(printer);
        Thread t2 = new Thread(printer);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class Printer implements Runnable {
    private int i = 1;

    @Override
    public void run() {
//        while (true) {
        synchronized (this) {
            for (; i <= 100; i++) {
                notify();
//                if (i <= 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "->" + i);
                i++;
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                } else {
//                    break;
//                }
            }
            //不唤醒进程阻塞程序不终止
            notifyAll();
        }
    }
}
