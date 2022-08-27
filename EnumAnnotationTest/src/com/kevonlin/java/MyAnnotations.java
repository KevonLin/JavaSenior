package com.kevonlin.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/27 上午10:10
 * @description 重复注解测试
 */

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
