package com.jiang.sort;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/12/14 16:52
 * \* 描述: 插入排序
 * \
 */
public class InsertSort {

    /**
     * 从小到大
     * @param arr
     * @return
     * @throws Exception
     */
    public static int [] sort(int[] arr) throws Exception{

        if (arr == null || arr.length == 0) {
            throw new Exception("数组为null或数据内的元素为空！");
        }

        int n = arr.length; // 数组的大小
        for(int i = 0; i < n; i++){
            int value = arr[i]; // 需要插入的值
            int j = i-1;
            // 查找插入的位置
            for(; j >=0; j--){
                if(value < arr[j]){
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
        return arr;
    }


    public static void main(String[] args) throws Exception {
        int [] arr = {5, 2, 4, 8, 1, 6, 7, 3};
        // int [] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        // int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int [] sortArr = InsertSort.sort(arr);
        System.out.println("最后结果："+ Arrays.toString(arr));
    }

}