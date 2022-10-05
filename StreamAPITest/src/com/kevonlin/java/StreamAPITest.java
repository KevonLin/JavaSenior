package com.kevonlin.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author KevonLin
 * @version 1.0
 * @description TODO
 * @date 2022/10/5 17:33
 */
public class StreamAPITest {

    //创建Stream方式1：集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream() 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    //创建Stream方式2:数组
    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        //Arrays类的static <T> Stream<T> stream(T[] array) 返回一个流
        IntStream stream = Arrays.stream(arr);
    }
}
