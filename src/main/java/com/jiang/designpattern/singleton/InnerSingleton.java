package com.jiang.designpattern.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 20:54
 * \* 描述: 静态内部类实现单例
 * \
 */
public class InnerSingleton {

    /**
     * 静态内部类
     */
    private static class InnerHandler{
        private static InnerSingleton innerSingleton = new InnerSingleton();
    }

    /**
     * 构造函数私有
     */
    private InnerSingleton(){

    }

    /**
     * 获取对象实例的方法
     * @return
     */
    private static InnerSingleton getInstance(){
        return InnerHandler.innerSingleton;
    }
}