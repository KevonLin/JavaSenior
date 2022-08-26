package com.kevonlin.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/26 下午3:28
 * @description ComparableTest
 */
public class ComparableTest {
    @Test
    public void test1() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("A", 1);
        arr[1] = new Goods("C", 3);
        arr[2] = new Goods("B", 2);
        arr[3] = new Goods("B", 5);
        arr[4] = new Goods("C", 4);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Goods implements Comparable {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}' + "\n";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods g1 = (Goods) o;
            if (price > g1.price) {
                return 1;
            } else if (price < g1.price) {
                return -1;
            } else {
                return 0;
            }
        }
        throw new RuntimeException("类型不正确");
    }
}
