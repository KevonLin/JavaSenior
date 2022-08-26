package com.kevonlin.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/26 上午10:37
 * @description JDK8日期时间类测试
 */
public class JDK8DateTimeTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        LocalDateTime ofTime = localDateTime.of(2020, 10, 20, 14, 20, 32);
        System.out.println(ofTime);

        //get...()
        System.out.println(localDateTime.getNano());
        System.out.println(localDateTime.getDayOfMonth());

        //with...()修改 不可变性
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //plus...()加
        System.out.println(localDateTime.plusDays(1));

        //
        LocalDateTime localDateTime2 = localDateTime.minusMinutes(5);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
    }
}
