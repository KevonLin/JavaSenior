package com.kevonlin.exer;

import org.junit.Test;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/24 下午8:25
 * @description 字符串指定位置和长度进行翻转
 */
public class StringReverseTest {
    public static void main(String[] args) {
        String str = "I'm KevonLin";
        System.out.println(str);
        String res = strReverse(str);
        System.out.println(res);
    }

    private static String strReverse(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length;
        int index;
        int len;
        char[] rch;

        return null;
    }

    private void swap(char[] ch, int a, int b) {
        char tmp;
    }

    @Test
    public void test1() {
        char a = '1';
        char b = '2';
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
