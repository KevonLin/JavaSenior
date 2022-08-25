package com.kevonlin.exer;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/24 下午7:48
 * @description 模拟trim删除字符串两端的空格
 */
public class TrimTest {
    public static void main(String[] args) {
        String str = "  Hello World   ";
        str.trim();
        System.out.println("操作前:" + str);
        String res = trim(str);
        System.out.println("操作后:" + res);
    }

    private static String trim(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length;
        for (int i = start; i < end; i++) {
            if (chars[i] == ' ') {
                start++;
            } else {
                break;
            }
        }
        for (int i = end - 1; i >= start; i--) {
            if (chars[i] == ' ') {
                end--;
            } else {
                break;
            }
        }

        return new String(str.substring(start, end));
    }
}