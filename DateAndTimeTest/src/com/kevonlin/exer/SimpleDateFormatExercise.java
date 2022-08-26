package com.kevonlin.exer;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/26 上午8:30
 * @description TODO
 */
public class SimpleDateFormatExercise {
    @Test
    public void test1() throws ParseException {
        String birth = "1999-06-19";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birth);
        long time = parse.getTime();
        java.sql.Date date = new java.sql.Date(time);
        System.out.println(date);
    }

    /**
     * @return void
     * @params []
     * @author kevonlin
     * @create 2022/8/26 上午8:32
     * @description 渔夫问题 从 1990-01-01 到某一天是在打鱼还是晒网
     **/
    @Test
    public void test2() throws ParseException {
        String endDate = "2020-09-08";
        boolean status = getStatus(endDate);
        if (status) {
            System.out.println("打渔");
        } else {
            System.out.println("晒网");
        }
    }

    private boolean getStatus(String endDate) throws ParseException {
        long startTime, endTime, timeStance, hour;
        int day;
        boolean[] arr = {false, true, true, true, false};

        String startDate = "1990-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date parseStartDate = sdf.parse(startDate);
        startTime = parseStartDate.getTime();

        Date parseEndDate = sdf.parse(endDate);
        endTime = parseEndDate.getTime();

        timeStance = endTime - startTime;
        hour = timeStance / 1000 / 60 / 60;
        day = (int) (hour % 5);

        return arr[day];
    }
}
