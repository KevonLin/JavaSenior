package com.kevonlin.java;

import java.util.Arrays;
import java.util.Date;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/25 下午4:45
 * @description TODO
 */
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        long l = System.currentTimeMillis();
        System.out.println(l);
        java.sql.Date date1 = new java.sql.Date(l);
        long time1 = date1.getTime();
        System.out.println(time1);
        System.out.println("==============");
        // java.util.Date --> java.sql.Date
//        java.sql.Date date2 = new Date(l);
        Date date2 = new Date();
        long time2 = date2.getTime();
        Date date4 = new Date(time2);
        System.out.println(date4);
        java.sql.Date date3 = new java.sql.Date(time2);
        System.out.println(date3);

        System.out.println("=========");
        //java.sql.Date --> java.util.Date
        Date date5 = new java.sql.Date(l);
        long time3 = date5.getTime();
        System.out.println(date5);
        Date date6 = new Date(time3);
        System.out.println(date6);

        char[] chars = new char[10];
        System.out.println(Arrays.toString(chars));
    }
}
