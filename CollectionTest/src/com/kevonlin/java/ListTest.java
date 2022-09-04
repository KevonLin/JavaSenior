package com.kevonlin.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author KevonLin
 * @version 1.1
 * @description |--Collection 单列集合
 * @date 2022/8/28 13:24
 * @modify 2022/9/4 16:39
 */
/*
 *      |--List 动态数组[有序、可重复]
 *          |--ArrayList
 *          |--LinkList
 *          |--Vector
 */
public class ListTest {
    @Test
    public void test1() {
        Collection list = new ArrayList();
        ArrayList coll = new ArrayList();
        coll.add(143);
        coll.add(456);
        list.add(123);
        list.addAll(coll);
        System.out.println(list);
        Iterator iterator = list.iterator();
        for (Object o : list) {
            System.out.println(o);
        }

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(list.contains(123));
    }
}
