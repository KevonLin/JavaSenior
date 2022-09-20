package com.kevonlin.java;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author KevonLin
 * @version 1.0
 * @description 反射测试
 * @date 2022/9/20 13:17
 */
public class ReflectionTest {
    @Test
    public void test1() throws Exception{
        Class<?> clazz = Class.forName("com.kevonlin.java.Person");
        Person p = (Person) clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        show.invoke(p,"中国");
    }
}
