package com.kevonlin.thread.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午12:47
 * @description TODO
 */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
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
            if (ticket > 0) {
                System.out.println(getName() + "->" + "售出" + ticket + "号票");
                ticket--;
            } else {
                break;
            }
        }
    }
}
