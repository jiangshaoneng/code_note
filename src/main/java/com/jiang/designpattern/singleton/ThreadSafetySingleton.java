package com.jiang.designpattern.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 20:45
 * \* 描述:线程安全单例，双检查锁
 * \
 */
public class ThreadSafetySingleton {

    // 声明实例对象
    private volatile static ThreadSafetySingleton threadSafetySingleton;

    /**
     * 构造函数私有
     */
    private ThreadSafetySingleton(){

    }

    /**
     * 获取对象实例的方法
     * @return
     */
    private static ThreadSafetySingleton getInstance(){
        if(threadSafetySingleton == null){
            // 假设在进入同步方法前，一段时间处理某些工作。synchronized的范围尽可能小，可能提升效率
            synchronized (ThreadSafetySingleton.class){
                if(threadSafetySingleton == null){
                    threadSafetySingleton = new ThreadSafetySingleton();
                }
            }
        }
        return threadSafetySingleton;
    }

}