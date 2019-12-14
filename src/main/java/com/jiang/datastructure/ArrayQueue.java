package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/21 20:51
 * \* 描述:
 * \* 通过数组实现队列 队列的特点:
 * \*  1,先进后出
 * \*  2,队头插入数据，队尾取出数据
 *  
 */
public class ArrayQueue{
    
    private int capacity; // 容量
    private int size; // 队列大小
    private Object[] queue; // 定义数组，保存数据

    public ArrayQueue(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.queue = new Object[capacity];
    }

    /**
     * 入队列
     */
    public boolean inQueue(Object obj){
        if(capacity <= size){ // 队列已满，不能加入
            return false;
        }
        // "1" "2" "3" "4" "5" --> "obj" "1" "2" "3" "4" "5"
        for (int i = size-1; i >= 0; i--) {
            queue[i+1] = queue[i];
        }
        queue[0] = obj;
        size++;
        return true;
    }

    /**
     * 出队列
     */
    public Object outQueue(){
        Object obj = null;
        if(size > 0){
            obj = queue[size-1];
            queue[size-1] = null;
            size--;
        }
        return obj;
    }

    /**
     * 清空队列
     */
    public ArrayQueue reset(){
        this.size = 0;
        return this;
    }

    /**
     * 打印队列信息
     * @return
     */
    public void showAll(){
        System.out.println("队列大小:"+ size +";容量为:" + capacity);
        System.out.print("打印队列内容:");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i]+" --> ");
        }
        System.out.println();
    }
}