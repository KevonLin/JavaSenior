package com.kevonlin.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/25 下午10:09
 * @description TODO
 */
public class DateTimeTest {

    @Test
    public void test1() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        System.out.println("=========");

//        String dateStr = "2022/08/25 22:22";
        String dateStr = "22-8-25 下午10:22";
        try {
            Date parse = sdf.parse(dateStr);
            System.out.println(parse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("=========");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String format1 = sdf1.format(date);
        System.out.println(format1);
        try {
            Date parse = sdf1.parse("2020-11-25 11:20");
            System.out.println(parse);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
