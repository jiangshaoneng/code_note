package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/29 12:18
 * \* 描述: 数组实现有序集合
 * \
 */
public class JArrayList {

    private final static int DEFAULT_CAPACITY = 10; // 默认容量大小

    private int size; // 集合当前的大小
    private int capacity; // 集合容量
    private Object[] data; // 存储数据

    public JArrayList (int n){
        if( n> 0 && n < Integer.MAX_VALUE){
            this.data = new Object[n];
            this.capacity = n;
            this.size = 0;
        }else {
            System.out.println("创建失败！初始化集合大小异常...");
        }
    }

    /**
     * 获取集合当前的大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 添加一个元素
     * @param obj
     */
    public void add(Object obj){

        if(size == capacity){
            int otherCapcaity;
            if(capacity > Integer.MAX_VALUE / 2) {
                otherCapcaity = Integer.MAX_VALUE;
            }else{
                // 扩容 * 2
                otherCapcaity = capacity * 2;
            }
            // 将数据复制到扩容后的数组中
            Object[] otherData = new Object[otherCapcaity];
            for (int i = 0; i < size ; i++){
                otherData[i] = data[i];
            }
            data = otherData;
            capacity = otherCapcaity;
        }
        // 添加到数组的末尾
        data[size] = obj;
        size ++;
    }

    /**
     * 删除一个元素
     */
    public void remove(int index){
        // 缩容: 当前元素的数量小于容量的1/4的时候，容量缩小为原来的1/2
        if(capacity > DEFAULT_CAPACITY && size <= capacity / 4){
            int otherCapcaity = capacity / 2;
            Object[] otherData = new Object[otherCapcaity];
            for (int i = 0; i < size ; i++){
                otherData[i] = data[i];
            }
            data = otherData;
            capacity = otherCapcaity;
        }
        // 移除对应下标的元素
        for (int i = index; i < size-1; i++){
            data[i] = data[i+1];
        }
        this.size --;
    }

    /**
     * 根据下标获取元素
     * @param index
     * @return
     */
    public Object get(int index){
        if(cheackIndex(index))
            return this.data[index];
        else
            return null;
    }

    /**
     * 替换对应下标的数据
     * @param index
     * @param obj
     * @return
     */
    public Object update(int index, Object obj){
        if(!cheackIndex(index)) return null;

        data[index] = obj;
        return obj;
    }

    private boolean cheackIndex(int index){
        if(index < 0 || index > size){
            System.out.println("下标不存在...");
            return false;
        }
        return true;
    }

    /**
     * 打印集合信息
     */
    public void showInfo(){
        System.out.println("集合大小："+this.size+"集合容量："+this.capacity);
        for (int i = 0; i < size; i++){
            System.out.print(data[i]+"-->");
        }
        System.out.println();
    }
}