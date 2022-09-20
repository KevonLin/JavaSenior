package com.kevonlin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author KevonLin
 * @version 1.0
 * @description 动态代理测试
 * @date 2022/9/20 13:30
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("神户龙虾");

        System.out.println("=========================");

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        proxyInstance1.produceCloth();
    }
}

interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {
    @Override
    public String getBelief() {
        return "错的不是我是全世界!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃:" + food);
    }
}

//代理类
class ProxyFactory {
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object obj;//需要使用被代理类对象赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 通过代理类的对象调用方法时就会自动调用invoke()
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}