package com.kevonlin.thread.thread.security.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午3:59
 * @description 同步方法解决接口方式多线程安全问题
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    private int ticket = 100;
    private boolean haveTickets = true;

    @Override
    public void run() {
        while (haveTickets) {
            sell();
        }
    }

    private synchronized void sell() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "售出" + ticket + "号票");
            ticket--;
        } else {
            haveTickets = false;
        }
    }
}