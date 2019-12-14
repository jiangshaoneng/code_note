package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/22 14:33
 * \* 描述: 环形队列
 *
 */
public class ArrayCircularQueue {

    private int capacity; // 容量
    private int size; // 定义数组的大小
    private int headPoint; // 头指针
    private int tailPoint; // 尾指针
    private Object[] queue; // 定义数组，保存数据

    public ArrayCircularQueue(int capacity){
        this.capacity = capacity;
        this.headPoint = 0;
        this.tailPoint = 0;
        this.size = capacity + 1; // 环形队列需要多给一个空间来判断队列空和满
        this.queue = new Object[size];
    }

    /**
     * 队列是否空
     * @return
     */
    public boolean isEmpty(){
        return headPoint == tailPoint;
    }

    /**
     * 队列是否满
     * @return
     */
    public boolean isFull(){
        if(tailPoint == headPoint){
            return false;
        }else if(tailPoint > headPoint){
            return tailPoint - headPoint == capacity;
        }else{
            return tailPoint + size - headPoint == capacity;
        }
    }

    /**
     * 入队
     * @return
     */
    public boolean inQueue(Object obj){
        if(isFull()) return false;

        queue[tailPoint] = obj;
        tailPoint = getNextPoint(tailPoint);
        return true;
    }

    /**
     * 出队
     * @return
     */
    public Object outQueue(){
        if(isEmpty()) return false;

        Object obj = queue[headPoint];
        queue[headPoint] = null;
        headPoint = getNextPoint(headPoint);
        return obj;
    }

    /**
     * 顺时针获取下一个结点
     * @param point
     * @return
     */
    private int getNextPoint(int point){
        if(size == point + 1){
            return 0;
        }else{
            return ++point;
        }
    }

    /**
     * 获取当前队列元素的个数
     * @return
     */
    private int length(){
        if(tailPoint >= headPoint){
            return tailPoint - headPoint;
        }else{
            return tailPoint + size - headPoint;
        }
    }

    /**
     * 查看队列信息
     */
    public void showInfo(){
        System.out.println("队列大小："+capacity+";队列占的空间："+size+";headPoint："+headPoint+";tailPoint:"+tailPoint);
        for (int i = 0; i < length(); i++){
            int x = headPoint + i;
            if(x >= size) x = x - size;
            System.out.print(queue[x] + "<--");
        }
        System.out.println("");
    }
}