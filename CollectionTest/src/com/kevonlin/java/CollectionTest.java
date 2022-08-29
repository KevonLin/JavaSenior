package com.kevonlin.java;

import org.junit.Test;

import java.util.*;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/27 上午11:58
 * @description 集合框架和API
 */

/*
 * 集合框架
 * |--Collection 单列集合
 *      |--List 动态数组[有序、可重复]
 *          |--ArrayList、LinkList、Vector
 *      |--Set  数学集合[无序、不重复]
 *          |--HashSet、LinkedHashSet、TreeSet
 * |--Map 双列集合[Key-Value] 数学函数
 *      |--HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 */

public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        //add(Object o)
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());
        //size()
        System.out.println(coll.size());

        //addAll(Collection coll1) coll1的所有元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //clear() 清除不是赋值null
        coll.clear();
        System.out.println(coll.isEmpty());

        //isEmpty()
        Collection coll2 = new ArrayList();
        //没添加元素为null 空指针异常
//        System.out.println(coll2.isEmpty());
    }

    /**
     * @author KevonLin
     * @description Collection接口中声明方法的测试
     * @create 2022/8/28 12:19
     **/
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Jerry"));
        coll.add(false);
        Person p = new Person("Tom", 18);
        coll.add(p);
        coll.add(new Person("Tom", 18));

        // 1.contains(Object obj) 判断当前集合是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);

        //contains判断的是内容
        System.out.println(coll.contains(new String("Jerry")));
        System.out.println(coll.contains(p));

        //调用Person中的equals 没写调用父类Object的 Object是==判断 所以是false
        System.out.println(coll.contains(new Person("Tom", 18)));//false 重写equals后为true

        // 2.containsAll(Collection coll) 判断形参coll中的所有元素是否都在当前集合中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));
        Collection coll2 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll2));
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Jerry"));
        coll.add(false);
        coll.add(new Person("Tom", 18));

        // 3.remove(Object obj)从当前集合中删除obj元素
        boolean remove = coll.remove(123);
        System.out.println(remove);//true删除成功

        // 4.removeAll(Collection coll) 当前集合中去掉coll集合的全部共有元素
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);

        // 5.retainAll(Collection coll)求交集
        Collection coll2 = Arrays.asList(false, "Jerry");
        coll.retainAll(coll2);
        System.out.println(coll);
    }

    @Test
    public void test4() {
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Jerry"));
        coll1.add(false);
        coll1.add(new Person("Tom", 18));

        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        coll2.add(new String("Jerry"));
        coll2.add(false);
        coll2.add(new Person("Tom", 18));

        // 6.equals(Object obj) 元素顺序必须一样 因为ArrayList是有序的
        boolean equals = coll1.equals(coll2);
        System.out.println(equals);
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Jerry"));
        coll.add(false);
        coll.add(new Person("Tom", 18));

//        7.hashCode()
        System.out.println(coll.hashCode());

        // 8.集合-->数组
        Object[] objects = coll.toArray();
        System.out.println(Arrays.toString(objects));

        // 9.数组-->集合
        List<String> list = Arrays.asList(new String[]{"AA", "ABB"});
        System.out.println(list);

        List<Integer> integers = Arrays.asList(new Integer[]{123, 456});
        System.out.println(integers.size());// 2

        List<int[]> ints = Arrays.asList(new int[]{123, 132});
        System.out.println(ints.size());// 1

        // 10.iterator() 返回Iterator接口实例
    }
}
