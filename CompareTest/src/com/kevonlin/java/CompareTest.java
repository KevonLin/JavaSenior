package com.kevonlin.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/26 下午3:06
 * @description Comparable 和 Comparator
 */
public class CompareTest {

    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "CC", "GG", "DD", "JJ"};
        Arrays.sort(arr, new Comparator() {
            //按照字符串从大到小的顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("类型不正确");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @return void
     * @params []
     * @author kevonlin
     * @create 2022/8/26 下午3:14
     * @description 自定义类的排序
     **/
    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("A", 1);
        arr[1] = new Goods("C", 3);
        arr[2] = new Goods("B", 2);
        arr[3] = new Goods("B", 5);
        arr[4] = new Goods("C", 4);

        Arrays.sort(arr, new Comparator() {
            //名称顺序 价格逆序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        if (g1.getPrice() > g2.getPrice()) {
                            return -Double.compare(g1.getPrice(), g2.getPrice());
                        }
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
//                return 0;
                throw new RuntimeException("类型不正确");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    private class Goods {
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
    }
}
