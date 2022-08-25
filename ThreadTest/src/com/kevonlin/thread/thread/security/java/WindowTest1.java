package com.kevonlin.thread.thread.security.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午3:32
 * @description TODO
 */
public class WindowTest1 {
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
            synchronized (this) {
                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    System.out.println(Thread.currentThread().getName() + "售出" + ticket + "号票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
