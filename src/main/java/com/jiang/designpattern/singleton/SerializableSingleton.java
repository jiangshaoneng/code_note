package com.jiang.designpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 21:02
 * \* 描述:实现序列化的对象实现单例
 * \
 */
public class SerializableSingleton implements Serializable {

    /**
     * 静态内部类
     */
    private static class InnerHandler{
        private static SerializableSingleton serializableSingleton = new SerializableSingleton();
    }

    /**
     * 构造函数私有
     */
    private SerializableSingleton(){

    }

    /**
     * 获取对象实例的方法
     * @return
     */
    private static SerializableSingleton getInstance(){
        return InnerHandler.serializableSingleton;
    }

    /**
     * 解决实现序列化接口的类，在反序列话时不是同一个对象的问题
     * @return
     * @throws ObjectStreamException
     */
    protected Object readResolve() throws ObjectStreamException {
        return InnerHandler.serializableSingleton;
    }

}