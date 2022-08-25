package com.kevonlin.thread.java;

import java.util.concurrent.*;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/23 上午8:01
 * @description 线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        //线程池属性
        System.out.println(service.getClass());
//      ThreadPoolExecutor是ThreadPoolExecutor的子类
        ThreadPoolExecutor pool = (ThreadPoolExecutor) service;
        //线程池属性
        //核心池
        pool.setCorePoolSize(10);
//        最大线程数
        pool.setMaximumPoolSize(10);
        pool.setKeepAliveTime(5, TimeUnit.SECONDS);
        //适合使用Runnable
        service.execute(new NumThread());
        Future submit = service.submit(new NumThread1());

        service.shutdown();

        //适合使用Callable
//        service.submit();
    }
}

class NumThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
    }
}

class NumThread1 implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "->" + i);
            }
        }
        return null;
    }
}