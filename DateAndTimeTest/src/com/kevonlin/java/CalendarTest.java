package com.kevonlin.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/26 上午9:08
 * @description TODO
 */
public class CalendarTest {
    @Test
    public void test1() {
        //方式1
//        GregorianCalendar gregorianCalendar = new GregorianCalendar();
//        gregorianCalendar.getTime();

        //方式2
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        int weeks = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(weeks);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime()
        Date date = new Date();
        calendar.setTime(date);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

}
