package com.kevonlin.exer;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/25 下午3:27
 * @description 模式串匹配
 * 1.简单算法(朴素算法)
 * 2.首尾匹配算法
 * 3.KMP算法
 */
public class StringMatchTest {

    /**
     * @return int 若匹配到返回匹配到的索引
     * @params [src 原字符串, tar 模式串, pos 起始位置]
     * @author kevonlin
     * @create 2022/8/25 下午3:37
     * @description 简单算法（朴素算法）
     **/
    public static int index(@NotNull String src, @NotNull String tar, int pos) {
        char[] S = src.toCharArray();
        char[] T = tar.toCharArray();

        int i = pos, j = 0;//i是原串，j是模式串
        while (i < S.length && j < T.length) {
            if (S[i] == T[j]) {
                i++;
                j++;
            } else {
                i = i - j + 2;
                j = 0;
            }
        }
        if (j >= T.length) {
            return i - T.length;
        } else {
            return -1;
        }
    }

    @Test
    public void test1() {
        String s = "abcadcabdabc";
        String t = "abd";
        int index = index(s, t, 0);
        System.out.println(index);//6
    }

    @Contract(pure = true)
    public static int @Nullable [] getNext(@NotNull String T) {
        int[] next = new int[T.length()];
        next[0] = 0;
        next[1] = 1;
        for (int i = 2, k = 0; i < T.length(); ++i) {//for循环,从第二个字符开始,依次计算每一个字符对应的next值
            while (k > 0 && (T.charAt(i - 1) != T.charAt(k))) {//递归的求出p[0]...p[q]的最大前后缀长度
                k = next[k - 1];
            }
            if (T.charAt(i - 1) == T.charAt(k)) {//如果相等，那么最前后缀长度加1
                k = next[i - 1] + 1;
            } else {
                k = 1;
            }
            next[i] = k;
        }
        return next;
    }

    @Test
    public void test2() {
        String t = "abaabcac";
        int[] next = getNext(t);
        System.out.println(Arrays.toString(next));//01122312
    }
}
