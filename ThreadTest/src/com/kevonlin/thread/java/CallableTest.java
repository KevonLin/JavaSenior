package com.kevonlin.thread.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/23 上午7:46
 * @description 实现Callable接口创建线程
 */
public class CallableTest {
    public static void main(String[] args) {
        Printer printer = new Printer();
        FutureTask futureTask1 = new FutureTask(printer);
        FutureTask futureTask2 = new FutureTask(printer);
        Thread t1 = new Thread(futureTask1);
        Thread t2 = new Thread(futureTask2);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
        Object sum = null;
        try {
            //get()返回值即call()的返回值
            sum = futureTask1.get();
            sum = futureTask2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sum = " + sum);
    }
}

class Printer implements Callable {
    private int sum;

    @Override
    public Object call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        // 自动装箱
        return sum;
    }


}
