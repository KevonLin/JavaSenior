package com.kevonlin.thread.exer;

/**
 * @author kevonlin
 * @version 1.0
 * @create 2022/8/23 下午5:47
 * @description 单线程电梯调度练习
 * 需求描述
 * 1.电梯单独运行初始在1楼
 * 2.当某个电梯按下按钮时获取到请求
 * 3.当电梯满员时忽略楼层拦截
 * 设计方案
 * Elevator类
 * MIN_STAIR = 1
 * MAX_STAIR = 9
 * initStair = 1
 * private int stairNow
 * private int toStair
 * void upstairs()
 * void downstairs()
 * <p>
 * Person类
 * private int nowAt
 * upReq()
 * downReq()
 */
public class ElevatorTest {
}

class Elevator {
    public static final int MIN_STAIR = 1;
    public static final int MAX_STAIR = 9;

    private final int initStair = 1;
    private int stairNow = 1;
    private int toStair;
    private boolean reqStair[] = new boolean[MAX_STAIR + 1];
    private boolean isUp;
    private boolean isDown;

    public void upstairs(Person p) {
        stairNow = p.upReq();
        System.out.println("电梯到达[" + toStair + "]楼");
    }

    private boolean haveReq() {
        for (boolean b : reqStair) {
            if (b) {
                return true;
            }
        }
        return false;
    }

    public void downstairs(Person p) {
        stairNow = p.downReq();
        System.out.println("电梯到达[" + toStair + "]楼");
    }

    private int goWhatStair() {
        if (isUp && (stairNow < toStair)) {

        }
        return toStair;
    }

    private void getNextStair(Person p) {
        p.upReq();
    }

    private boolean isValidStairs() {
        return toStair <= MAX_STAIR && toStair >= MIN_STAIR && reqStair[toStair];
    }
}

class Person {
    private final int nowAt;

    public Person(int nowAt) {
        this.nowAt = nowAt;
    }

    public int upReq() {
        if (nowAt < Elevator.MAX_STAIR) {
            return nowAt;
        } else {
            throw new ElevatorException("当前楼层无法向上");
        }
    }

    public int downReq() {
        if (nowAt > Elevator.MIN_STAIR) {
            return nowAt;
        } else {
            throw new ElevatorException("当前楼层无法向上");
        }
    }
}

class ElevatorException extends RuntimeException {
    static final long serialVersionUID = -7034897190745762339L;

    public ElevatorException(String message) {
        super(message);
    }
}