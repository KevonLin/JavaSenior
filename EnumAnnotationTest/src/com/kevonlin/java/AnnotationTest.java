package com.kevonlin.java;

import java.util.ArrayList;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/27 上午8:45
 * @description 注解的使用 自定义注解
 * 元注解 -> 注解注解的注解
 * Retention 生命周期
 * Target 注解修饰目标
 * Documented javadoc解析时保留
 * Inherited 具有继承性 子类也会有相同注解
 * <p>
 * JDK8新特性
 * 1.重复注解
 * 2.类型注解 TYPE_PARAMETER TYPE_USE
 */
//定义不能修饰类
//@MyAnnotationTest
public class AnnotationTest {
    public static void main(String[] args) {
        AnnotationTest test = new AnnotationTest();
        test.test1();
        test.test2();
        test.test3();
    }
    @SuppressWarnings("unused")
    public void test1() {
    }

    //需要配置
    //JDK8前写法
    @MyAnnotations({@MyAnnotation(value = "h"), @MyAnnotation(value = "w")})
    public void test2() {
    }

    @MyAnnotation(value = "1")
    @MyAnnotation(value = "2")
    public void test3() {
    }
}

class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> strings = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}