package com.kevonlin.exer;

import java.util.Arrays;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/25 上午8:24
 * @description 获取一个字符串在另一个字符串中出现的次数
 */
public class StringCountTest {
    public static void main(String[] args) {
        String str = "googoglgogoloooogogoleglegoogle";
        String tar = "gogol";
        str.indexOf(tar);
        int[] next = getNext(tar);//01123
        System.out.println(Arrays.toString(next));
//        int count = stringCount(str, target);
//        System.out.println("[" + target + "]在字符串[" + str + "]中出现了[" + count + "]次"); // 2次
    }

    public static int stringCount(String source, String target) {
        char[] src = source.toCharArray();
        char[] tar = target.toCharArray();
        int[] nextVal = getNextVal(tar);
        int count = 0;
        return count;
    }

    public static int[] getNext(String target) {
        int[] next = new int[target.length()];
        return next;
    }

    public static int[] getNextVal(char[] target) {
        return null;
    }

}

