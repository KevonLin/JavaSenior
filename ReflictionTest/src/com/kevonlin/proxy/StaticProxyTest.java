package com.kevonlin.proxy;

/**
 * @author KevonLin
 * @version 1.0
 * @description 静态代理
 * @date 2022/9/20 13:32
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        ClothFactory nike = new NikeClothFactory();
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备中...");
        factory.produceCloth();
        System.out.println("代理工厂善后...");
    }
}

class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产运动服");
    }
}