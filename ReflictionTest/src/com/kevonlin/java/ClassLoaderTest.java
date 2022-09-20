package com.kevonlin.java;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author KevonLin
 * @version 1.0
 * @description ClassLoader读取配置文件
 * @date 2022/9/20 12:58
 */
public class ClassLoaderTest {
    @Test
    public void test1() throws Exception {
        Properties pros = new Properties();

        // 方式一 相对路径在module下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        // 方式二 相对路径在当前module的src下
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String usr = pros.getProperty("usr");
        String pwd = pros.getProperty("pwd");
        System.out.println("usr=" + usr + "\n" + "pwd=" + "=" + pwd);
    }
}
