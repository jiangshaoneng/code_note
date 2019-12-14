package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/12/6 23:52
 * \* 描述: 双向链表
 * \
 */
public class DoubleLink {

    private Node head = null; // 头节点
    private int length = 0; // 链表长度

    /**
     * 获取指定位置的元素
     * @return
     */
    public Node getByIndex(int index){
        if(!cheackIndex(index)) return null;

        Node temp = head;
        int i = 0;
        while (i < index){
            temp = temp.next;
            i++;
        }
        return temp;
    }

    /**
     * 在链表的头部添加一个元素
     * @return
     */
    public boolean addHeadElement(Object obj){
        Node newNode = new Node(null, obj, null);

        if(length == 0){ // 若是空链表的时候，该节点就是头节点
            head = newNode;
        }else{ // 否则，在头部添加一个元素
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
        return true;
    }

    /**
     * 在链表最后添加一个元素
     * @return
     */
    public boolean addLastElement(Object obj){
        Node newNode = new Node(null, obj, null);

        if(length == 0){ // 若是空链表的时候，该节点就是头节点
            head = newNode;
        }else{ // 否则，找到最后一个元素，在其后面添加新的元素
            Node lastNode = getByIndex(length - 1);
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
        length++;
        return true;
    }

    /**
     * 将元素添加到指定位置
     * @return
     */
    public boolean addElement(Object obj, int index){
        if(!cheackIndex(index)) return false;

        Node newNode = new Node(null, obj, null);

        if(length == 0){ // 若是空链表的时候，该节点就是头节点
            head = newNode;
        }else{ // 否则，查找到指点元素
            Node indexNode = getByIndex(index);
            if(indexNode.next == null){
                Node lastNode = getByIndex(length - 1);
                lastNode.next = newNode;
                newNode.prev = lastNode;
            }else if(indexNode.prev == null){
                head.prev = newNode;
                newNode.next = head;
                head = newNode;
            }else{
                // 1 = 2 = 3
                // 1 = 2 = 100 = 3
                indexNode.prev.next = newNode;
                newNode.prev = indexNode.prev;
                newNode.next = indexNode;
                indexNode.prev = newNode;
            }
        }
        length++;
        return false;
    }

    /**
     * 删除链表头部一个元素
     * @return
     */
    public boolean removeHeadElement(){
        if(length == 0) {
            return false;
        } else if(length == 1){
            head = head.next;
        } else {
            head = head.next;
            head.prev = null;
        }
        length--;
        return true;
    }

    /**
     * 删除链表最后一个元素
     * @return
     */
    public boolean removeLastElement(){
        if(length == 0){
            return false;
        }else if(length == 1){
            head = null;
        } else {
            Node lastNode = getByIndex(length - 1);
            lastNode.prev.next = null;
            lastNode.prev = null;
        }
        length--;
        return true;
    }

    /**
     * 删除链表指定位置元素
     * @return
     */
    public boolean removeElement(int index){
        if(length == 0){
            return false;
        }else{
            Node indexNode = getByIndex(index);
            if(indexNode.next == null){
                indexNode.prev.next = null;
                indexNode.prev = null;
            }else if(indexNode.prev == null){
                head = indexNode.next;
                indexNode.next.prev = null;
            }else{
                indexNode.prev.next = indexNode.next;
                indexNode.next.prev = indexNode.prev;
            }
            length--;
            return true;
        }
    }

    /**
     * 校验指定位置是否合法
     */
    public boolean cheackIndex(int index){
        return index >= 0 && index <= length - 1;
    }

    /**
     * 打印
     */
    public void showInfo(){
        System.out.println("链表长度：" + length);
        Node temp = head;
        while (temp != null){
            System.out.print(temp.element + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

}