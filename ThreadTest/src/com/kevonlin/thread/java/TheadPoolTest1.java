package com.kevonlin.thread.java;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/24 下午7:10
 * @description TODO
 */
public class TheadPoolTest1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());
        ThreadPoolExecutor svc = (ThreadPoolExecutor) service;
//        svc.setMaximumPoolSize(2);
//        svc.setKeepAliveTime(1, TimeUnit.SECONDS);
//        svc.setCorePoolSize(1);
        MyFactory myFactory = new MyFactory();
//        svc.setThreadFactory(myFactory);
        FutureTask<Integer> task = new FutureTask<Integer>(myFactory);
        svc.submit(task);
        try {
            int sum = task.get();
            System.out.println("Sum = " + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        svc.shutdown();
    }
}

class MyFactory extends Thread implements Callable, ThreadFactory {

    private int sum = 0;

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }

    @Override
    public Thread newThread(@NotNull Runnable r) {
        return new MyFactory();
    }
}
