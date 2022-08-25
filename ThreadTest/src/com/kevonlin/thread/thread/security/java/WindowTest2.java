package com.kevonlin.thread.thread.security.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午2:52
 * @description TODO
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("1号窗口");
        w2.setName("2号窗口");
        w3.setName("2号窗口");
        w1.start();
        w2.start();
        w3.start();

    }
}

class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            //拿Thread类的对象也可以，容易与其他类拿到同一个同步监视器[同一把锁]
//            synchronized (Thread.class) {
            synchronized (Window.class) {
                if (ticket > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName() + "售出" + ticket + "号票");
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}