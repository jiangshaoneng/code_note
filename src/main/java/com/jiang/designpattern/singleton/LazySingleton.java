package com.jiang.designpattern.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 20:37
 * \* 描述:懒汉模式
 *
 * 缺点：在多线程下时不安全的
 */
public class LazySingleton {

    // 声明实例对象
    private static LazySingleton lazySingleton;

    /**
     * 构造函数私有
     */
    private LazySingleton(){

    }

    /**
     * 获取对象实例的方法
     * @return
     */
    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}