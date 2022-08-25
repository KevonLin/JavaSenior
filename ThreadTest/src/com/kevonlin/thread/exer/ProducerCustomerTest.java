package com.kevonlin.thread.exer;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/22 下午11:00
 * @description 生产者消费者问题
 */
public class ProducerCustomerTest {
    public static void main(String[] args) {
//        Clerk clerk = Clerk.getClerk();
        Clerk clerk1 = new Clerk("员工1");

        Producer p1 = new Producer(clerk1);
        Thread tp1 = new Thread(p1);
        tp1.setName("生产者1");
        tp1.start();

        Customer c1 = new Customer(clerk1);
        Thread tc1 = new Thread(c1);
        tc1.setName("消费者1");
        tc1.start();

        Thread tcl1 = new Thread(clerk1);
        tcl1.setName(clerk1.getName());
        tcl1.start();
    }
}

class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

//    public void produce(Clerk c) {
////        int count = c.getProductsCount();
////        if (count < Clerk.MAX_PRODUCT) {
////            c.setProductsCount(count + 1);
////        }
//    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->正在生产");
        while (true) {
            try {
                Thread.sleep(100);
                clerk.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Customer implements Runnable {
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

//    public void consume(Clerk c) {
//        int count = c.getProductsCount();
//        if (count > Clerk.MIN_PRODUCT) {
//            c.setProductsCount(count - 1);
//        }
//    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "->正在消费");
        while (true) {
            try {
                Thread.sleep(100);
                clerk.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Clerk implements Runnable {
    public static final int MIN_PRODUCT = 0;
    public static final int MAX_PRODUCT = 20;
//    private Semaphore semaphore = new Semaphore(0);

//    public static boolean canConsume = false;
//    public static boolean canProduce = false;

    private static int productsCount = 0;
    private String name;

    public Clerk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void produce() throws InterruptedException {
        if (productsCount < MAX_PRODUCT) {
            productsCount++;
            System.out.println("正在从[" + Thread.currentThread().getName() + "]购入第[" + productsCount + "]个产品");
//            notify();
        } else {
//            wait();
        }
    }

    public void consume() throws InterruptedException {
        if (productsCount > MIN_PRODUCT) {
            System.out.println("正在从[" + Thread.currentThread().getName() + "]售出第[" + productsCount + "]个产品");
            productsCount--;
//            notify();
        } else {
//            wait();
        }
    }

    //只有一个店员的情况
//    private static Clerk clerk = new Clerk();
//
//    private Clerk() {
//    }
//
//    public static Clerk getClerk() {
//        if (clerk == null) {
//            synchronized (Clerk.class) {
//                if (clerk == null) {
//                    clerk = new Clerk();
//                }
//            }
//        }
//        return clerk;
//    }

//    public int getProductsCount() {
//        return productsCount;
//    }
//
//    public void setProductsCount(int productsCount) {
//        this.productsCount = productsCount;
//    }

    @Override
    public void run() {
        System.out.println("店员正在收购/出售");
    }
}
