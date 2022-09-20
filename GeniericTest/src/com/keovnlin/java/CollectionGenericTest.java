package com.keovnlin.java;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author KevonLin
 * @version 1.0
 * @description 定义一个 Employee 类， 该类包含：private 成员变量 name,age,birthday，其中 birthday 为 MyDate 类的 对象；
 * 并为每一个属性定义 getter, setter 方法； 并重写 toString 方法输出 name, age, birthday
 * MyDate 类包含: private 成员变量 month,day,year；并为每一个属性定义 getter, setter 方法；
 * <p>
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型 来定义），
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 继承 Comparable 接口，并按 name 排序 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 * @date 2022/9/5 22:42
 */
public class CollectionGenericTest {

    @Test
    public void test3() {
        List <? extends Person> list1 = null; // <=
        List <? super Person> list2 = null; // >=

        List<Person> list3 = null;
        List<Student> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;

        list2 = list3;
//        list2 = list4;
        list2 = list5;
    }

    @Test
    public void test2() {
        Employee e1 = new Employee("Tom", 12, new MyDate(1999, 6, 16));
        Employee e2 = new Employee("Jerry", 12, new MyDate(1999, 5, 16));
        Employee e3 = new Employee("Jack", 12, new MyDate(1993, 5, 26));
        Employee e4 = new Employee("Jim", 12, new MyDate(1979, 3, 13));
        Employee e5 = new Employee("LiHua", 12, new MyDate(1985, 8, 23));

        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                MyDate b1 = e1.getBirthday();
                MyDate b2 = e2.getBirthday();
                if (b1.getYear() == b2.getYear()) {
                    if (b1.getMonth() == b2.getMonth()) {
                        if (b1.getDay() == b2.getDay()) {
                            return 0;
                        } else {
                            return (b1.getDay() > b2.getDay()) ? 1 : -1;
                        }
                    } else {
                        return (b1.getMonth() > b2.getMonth()) ? 1 : -1;
                    }
                } else {
                    return (b1.getYear() > b2.getYear()) ? 1 : -1;
                }
            }
        });
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        for (Employee e : set) {
            System.out.println(e);
        }
    }

    @Test
    public void test1() {
        Employee e1 = new Employee("Tom", 12, new MyDate(1999, 6, 16));
        Employee e2 = new Employee("Jerry", 12, new MyDate(1959, 5, 16));
        Employee e3 = new Employee("Jack", 12, new MyDate(1993, 5, 26));
        Employee e4 = new Employee("Jim", 12, new MyDate(1979, 3, 13));
        Employee e5 = new Employee("LiHua", 12, new MyDate(1985, 8, 23));

        TreeSet<Employee> set = new TreeSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }
}
