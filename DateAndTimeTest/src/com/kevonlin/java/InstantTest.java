package com.kevonlin.java;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/26 上午10:49
 * @description Instant瞬时类
 */
public class InstantTest {
    @Test
    public void test1(){
        Instant instant = Instant.now();
        System.out.println(instant);//2022-08-26T02:51:00.635Z 本初子午线时间

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//东八区时间

        //获取1970-1-1 0时0分0秒到现在的时间(UTC)毫秒数
        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);
        Instant instant1 = Instant.ofEpochMilli(1661482460L);
        System.out.println(instant1);
    }

    /**
     * @params []
     * @return void
     * @author kevonlin
     * @create 2022/8/26 上午10:56
     * @description SimpleDateTimeFormat测试
     **/
    @Test
    public void test2(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = formatter.format(now);
        System.out.println(now);
        System.out.println(format);

        TemporalAccessor parse = formatter.parse("2022-08-26T10:59:55.889");
        System.out.println(parse);

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
//        String format1 = dateTimeFormatter.format(now);
        String format2 = dateTimeFormatter1.format(now);
        String format3 = dateTimeFormatter2.format(now);
        String format4 = dateTimeFormatter3.format(now);
//        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
        System.out.println(format4);

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM月dd日 HH:mm");
        String s = pattern.format(LocalDateTime.now());
        System.out.println(s);

        TemporalAccessor parse1 = pattern.parse("12月25日 14:25");
        System.out.println(parse1);
    }
}
