package com.kevonlin.exer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author kevonlin
 * @version 1.1
 * @create 2022/8/24 下午8:25
 * @description 字符串指定位置和长度进行翻转
 */
public class StringReverseTest {
    public static void main(String[] args) {
        String str = "I'm Kevon";
        System.out.println(str);
        String res = strReverse(str, 4, 5);
        System.out.println(res);
    }

    //方式一 转换为char[]
    @Contract("_, _, _ -> new")
    private static @NotNull String strReverse(@NotNull String str, int index, int length) {
        char[] chars = str.toCharArray();
        int start = index;
        int end = start + length - 1;
        char[] rch = null;
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars);
    }

    //方式二StringBuilder/StringBuffer
    public static String reverseUseStringBuilder(String str, int index, int length){
        StringBuilder builder = new StringBuilder(str.length());
        return null;
    }
}
