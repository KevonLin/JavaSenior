package com.keovnlin.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KevonLin
 * @version 1.0
 * @description 自定义泛型
 * @date 2022/9/6 12:46
 */
public class Order<T> {
    String name;
    int orderId;

    T orderT;

    public Order() {
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public <E> T getT() {
        return null;
    }

    public <E> List<E> copy(E[] arr) {
        ArrayList<E> arry = new ArrayList<>();
        for (E e : arr) {
            arry.add(e);
        }
        return arry;
    }


    @Test
    public void test1() {
        Order<String> stringOrder = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> copy = stringOrder.copy(arr);
//        for (Integer integer : copy) {
//            System.out.println(integer);
//        }
        System.out.println(copy);
    }
}



class Father<T1, T2> {
}

class Son1 extends Father { //未指定Father为<Object,Object>
    //没有类型
}

class Son<T1, T2> extends Father<T1, T2> {
    //全部保留
}

class Son3<T2> extends Father<Integer, T2> {
    //部分保留
}

class Son4<Integer, Float> extends Father<String, Double> {
    //全部修改
}

class Son2<T1, String> extends Father { //未指定Father为<Object,Object>
    //
}

class Son5<T1, T2, E1, E2> extends Father<T1, T2> {

}

