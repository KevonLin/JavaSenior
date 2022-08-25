package com.kevonlin.java;

import org.junit.Test;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/25 下午9:43
 * @description TODO
 */
public class IdeaDebug {
    @Test
    public void test1(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
