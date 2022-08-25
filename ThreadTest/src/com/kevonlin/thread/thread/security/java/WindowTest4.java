package com.kevonlin.thread.thread.security.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午3:58
 * @description TODO
 */
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("1号窗口");
        w2.setName("2号窗口");
        w3.setName("2号窗口");
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 extends Thread {
    private static int ticket = 100;
    private static boolean haveTickets = true;

    @Override
    public void run() {
        while (haveTickets) {
            sell();
        }
    }

    //若不是静态，则sell()同步监视器是w1,w2,w3
    public static synchronized void sell(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售出" + ticket + "号票");
            ticket--;
        } else {
            haveTickets = false;
        }
    }
}

