package com.kevonlin.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/27 上午9:14
 * @description 自定义注解类
 * <p>
 * Retention
 * SOURCE 编译时丢弃
 * CLASS[默认] 编译保留执行丢弃
 * RUNTIME 运行时保留 反射使用
 * <p>
 * Target
 */

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation {
    String value() default "Hello";
}
