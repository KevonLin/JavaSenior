package com.kevon.java;

import org.junit.Test;

import java.io.File;

/**
 * @author KevonLin
 * @version 1.0
 * @description IO流测试
 * @date 2022/9/6 13:57
 */
public class FileTest {
    @Test
    public void test2() {
        // renameTo()
        
    }

    @Test
    public void test1(){
        //相对路径 当前模块下
        File file1 = new File("test1.txt");
        File file2 = new File("F:\\Repository\\IdeaWorkSpace\\JavaSenior\\FileTest\\src\\com\\kevon\\java\\test2.txt");

        System.out.println(file1);
        System.out.println(file2);

        File file3 = new File("F:\\Repository\\IdeaWorkSpace\\JavaSenior\\", "FileTest");
        System.out.println(file3);

        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);
    }
}
