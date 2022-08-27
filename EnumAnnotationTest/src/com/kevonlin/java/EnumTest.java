package com.kevonlin.java;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/27 上午8:18
 * @description 枚举类测试
 * values()
 * valueOf()
 * toString()
 */
public class EnumTest {
    public static void main(String[] args) {
        Season autumn = Season.AUTUMN;
        System.out.println(autumn);

        Status busy = Status.valueOf("BUSY");
        System.out.println(busy);
        String status = busy.getStatus();
        System.out.println(status);
        String desc = busy.getDesc();
        System.out.println(desc);
    }
}

enum Status {
    BUSY("Busy", "我很忙"),
    FREE("Free", "我很闲"),
    VOCATION("Vocation", "度假中");

    private final String status;
    private final String desc;

    Status(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}

class Season {
    // 声明对象属性 private final
    private final String seasonName;
    private final String seasonDesc;

    // 私有化构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 枚举类多个对象
    public static final Season SPRING = new Season("春天", "我是春天");
    public static final Season SUMMER = new Season("夏天", "我是夏天");
    public static final Season AUTUMN = new Season("秋天", "我是秋天");
    public static final Season WINTER = new Season("冬天", "我是冬天");

    // 其他诉求
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
