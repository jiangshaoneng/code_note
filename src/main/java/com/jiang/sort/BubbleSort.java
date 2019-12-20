package com.jiang.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/12/14 13:50
 * \* 描述: 冒泡排序 时间复杂度 O(n^2)
 * \
 */
public class BubbleSort {

    /**
     * 排序,从小到大
     * @return
     */
    public static int [] sort(int[] arr) throws Exception{

        if (arr == null || arr.length == 0) {
            throw new Exception("数组为null或数据内的元素为空！");
        }

        int count = 0; // 经过多少次比较
        int n = arr.length;
        for (int i = 0; i < n; i++){
            boolean success = true;
            for (int j = 0; j < n - i - 1; j++){
                count++;
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    success = false;
                }
            }
            System.out.println("第"+(i + 1)+"轮："+ Arrays.toString(arr));
            // 再一轮比较的过程中没有元素交换，表示数组已经是有序的了。
            if(success){
                break;
            }
        }
        System.out.println(count);
        return arr;
    }

    public static void main(String[] args) throws Exception {
        // int [] arr = {5, 2, 4, 8, 1, 6, 7, 3};
        //int [] arr = {8, 7, 6, 5, 4, 3, 2, 1};
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int [] sortArr = BubbleSort.sort(null);
        System.out.println("最后结果："+ Arrays.toString(arr));
    }
}