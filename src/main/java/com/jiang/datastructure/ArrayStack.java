package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/22 14:03
 * \* 描述:
 * \* 通过数组实现栈
 * \* 栈的特点:
 * \* 1,先进先出
 * \* 2,栈顶插入元素,栈顶取出元素
 */
public class ArrayStack{

    private int capacity; // 容量
    private int size;   // 大小
    private Object[] stack;    // 定义数组，保存数据

    public ArrayStack(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.stack = new Object[capacity];
    }

    /**
     * 获取当前栈的元素个数
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否未空栈
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 是否未满栈
     * @return
     */
    public boolean isFull(){
        return size == capacity;
    }

    /**
     * 获取获取栈顶的元素
     * @return
     */
    public Object getTop(){
        if(isEmpty()) {
            return null;
        }
        return this.stack[size-1];
    }

    /**
     * 入栈
     * @return
     */
    public boolean inStack(Object obj){
        if(isFull()){ // 满栈不加入数据
            return false;
        }
        this.stack[size] = obj;
        size++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public Object outStack(){
        if(isEmpty()){ // 空栈无数据返回
            return null;
        }
        Object obj = this.stack[size-1];
        this.stack[size-1] = null;
        size--;
        return obj;
    }

    public void showInfo(){
        System.out.println("====== stack Info =======");
        System.out.println("当前栈的大小："+size+"容量为："+capacity);
        System.out.print("栈内数据为：");
        for (int i = 0; i< size; i++)
            System.out.print(stack[i]+"<--");
        System.out.println("");
    }
}