package com.kevonlin.thread.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午2:15
 * @description TODO
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window1 w = new Window1();
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

class Window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出" + ticket + "号票");
                ticket--;
            }
        }
    }
}