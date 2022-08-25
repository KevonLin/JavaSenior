package com.kevonlin.thread.thread.security.exer;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午7:25
 * @description 继承实现存钱
 */
public class AccountExerciseTest {
    public static void main(String[] args) {
        MyAccount account = new MyAccount(0);
        Custom c1 = new Custom(account);
        Custom c2 = new Custom(account);
        c1.setName("张三");
        c2.setName("李四");
        c1.start();
        c2.start();
    }
}

class MyAccount{
    private double balance;

    public MyAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit() {
        balance += 1000.0;
        System.out.println(Thread.currentThread().getName() + "存款成功");
        System.out.println("当前余额为" + balance);
    }
}

class Custom extends Thread{
    private MyAccount acc;

    public Custom(MyAccount acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            acc.deposit();
        }
    }


}
