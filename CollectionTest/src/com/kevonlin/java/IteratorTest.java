package com.kevonlin.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author KevonLin
 * @version 1.0
 * @description Iterator接口的使用
 * @date 2022/8/28 12:50
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Jerry"));
        coll.add(false);
        coll.add(new Person("Tom", 18));

        Iterator iterator = coll.iterator();
        //方式1
        //        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //NoSuchElementException
//        System.out.println(iterator.next());

//        //方式2
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式3
        while(iterator.hasNext()){
            //next()先指针下移 再返回数据 不用hasNext()会跳着输出
            System.out.println(iterator.next());
        }

        //foreach JDK5.0
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Jerry"));
        coll.add(false);
        coll.add(new Person("Tom", 18));

        Iterator iterator = coll.iterator();

        while(iterator.hasNext()){
            //调用next之前不能调用remove 指针还没有下移
//            iterator.remove();
            Object obj = iterator.next();
            //调用String的equals健壮性更好 若obj存null则空指针异常
//            if("Tom".equals(next)){
            if(obj.equals("Jerry")){
                // 遍历时删除指定元素 与Collection的remove不同
                iterator.remove();
                //删除两次和上次情况一样 指针没有移动
//                iterator.remove();
            }
        }

        //指针已经到最后 再遍历需要重新获取

        Iterator iterator1 = coll.iterator();

        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
