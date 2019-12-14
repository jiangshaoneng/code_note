package com.jiang.designpattern.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 20:31
 * \* 描述:饿汉模式实现单例
 *
 * 缺点：
 * 由于getInstance()，方法没用同步。
 * 因此getInstance()不能有其他变量，否则在多线程中时不安全的。
 */
public class HungrySingleton {

    // 立即加载对象，不提供创建对象的方法
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    /**
     * 构造函数私有
     */
    private HungrySingleton(){

    }

    /**
     * 获取对象实例的方法
     * @return
     */
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

}