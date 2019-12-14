package com.jiang.designpattern.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 21:09
 * \* 描述:使用静态代码块实现单例模式
 * \
 */
public class StaticBolckSingleton {

    // 声明对象
    private static StaticBolckSingleton staticBolckSingleton;

    /**
     * 构造函数私有
     */
    private StaticBolckSingleton(){

    }

    // 静态代码块实现对象创建
    static {
        staticBolckSingleton = new StaticBolckSingleton();
    }

    /**
     * 获取对象实例的方法
     * @return
     */
    public static StaticBolckSingleton getInstance(){
        return staticBolckSingleton;
    }
}