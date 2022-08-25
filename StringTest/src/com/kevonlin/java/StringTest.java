package com.kevonlin.java;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/23 下午8:24
 * @description TODO
 */
public class StringTest {

    @Test
    public void test1() {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2;
        String s4 = s1 + "World";
        String s5 = s1.intern() + "World";
        String s6 = "HelloWorld";
        String s7 = "Hello" + "World";
        String s8 = s5.intern();
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s6 == s7);
        System.out.println(s6 == s8);
    }

    @Test
    public void test2() {
        //String.valueOf()返回String在堆区
        int num = 123;
        String s1 = String.valueOf(num);
        String s2 = "123";
        System.out.println(s1 == s2);
    }

    @Test
    public void test3() {
        String str = "asd213";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        char[] arr = {'H', 'e', 'l', 'l', 'o'};
        String s = new String(arr);
        System.out.println(s);
        System.out.println(Arrays.toString(arr));
    }
}
