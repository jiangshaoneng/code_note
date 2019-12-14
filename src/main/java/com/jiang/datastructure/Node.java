package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/22 17:35
 * \* 描述:
 * \
 */
public class Node {

    Node prev; // 上一个节点
    Object element; // 节点存储数据的区域
    Node next; // 下一个节点

    public Node(Node prev, Object element, Node next){
        this.prev = prev;
        this.element = element;
        this.next = next;
    }

}