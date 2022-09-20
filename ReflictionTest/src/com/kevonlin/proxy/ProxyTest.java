package com.kevonlin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author KevonLin
 * @version 1.0
 * @description 动态代理
 * @date 2022/9/20 16:20
 */
public class ProxyTest {
    public static void main(String[] args) {
        Client client = new Client();
        MyProxyFactory instance = (MyProxyFactory) Proxy.getProxyInstance(client);
        String resource = instance.getResource();
        System.out.println(resource);
        instance.connect();

        System.out.println("=================");

        Singer singer = new Singer();
        MyProxyFactory singerInstance = (MyProxyFactory) Proxy.getProxyInstance(singer);
        singerInstance.doSomething();
    }
}

interface MyProxyFactory {
    String getResource();

    void connect();

    void doSomething();
}

class Client implements MyProxyFactory {

    @Override
    public String getResource() {
        return "客户端获取资源成功";
    }

    @Override
    public void connect() {
        System.out.println("客户端连接成功");
    }

    @Override
    public void doSomething() {
        System.out.println("客户端做了一些事情");
    }
}

class Singer implements MyProxyFactory{

    @Override
    public String getResource() {
        return null;
    }

    @Override
    public void connect() {

    }

    @Override
    public void doSomething() {
        System.out.println("歌手唱歌...");
    }
}

class MyHandler implements InvocationHandler {
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}

class Proxy {
    public static Object getProxyInstance(Object obj) {
        MyHandler handler = new MyHandler();
        handler.bind(obj);
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}