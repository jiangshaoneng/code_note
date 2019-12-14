package com.jiang.designpattern.singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/24 21:12
 * \* 描述: 枚举实现单例模式
 * \
 */
public class EnumSingleton {

    /**
     * 构造函数私有
     */
    private EnumSingleton(){

    }

    /**
     * 通过枚举类创建对象
     */
    private enum EnumSingletonHandler{

        INSTANCE;
        private EnumSingleton enumSingleton;

        //JVM保证只执行一次
        EnumSingletonHandler(){
            enumSingleton = new EnumSingleton();
        }

        // 返回单例对象
        public EnumSingleton getInstance(){
            return enumSingleton;
        }
    }

    /**
     * 获取对象实例的方法
     * @return
     */
    public static EnumSingleton getInstance(){
        return EnumSingletonHandler.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}