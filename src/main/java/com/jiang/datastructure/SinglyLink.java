package com.jiang.datastructure;

/**
 * \* Created with IntelliJ IDEA.
 * \* 作者: jiang
 * \* 日期/时间: 2019/11/22 17:10
 * \* 描述: 单向链表
 * \
 */
public class SinglyLink {

    private Node head = null; // 头节点
    private int length = 0; // 链表长度

    /**
     * 校验输入的下标是否合法
     * @param index:元素位置
     * @return: 输入是否合法
     */
    public boolean cheackIndex(int index){
        //int length = getLength();
        if(index < 0 || index > length-1){
            System.out.println("输入的下标不合法...");
            return false;
        }else{
            return true;
        }
    }

    /**
     * 获取指定位置的元素
     * @param index:元素位置
     * @return: 返回对应位置的节点
     */
    public Object getByIndex(int index){

        if(!cheackIndex(index)) return null;

        int i = 0;
        Node temp = head;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    /**
     * 在链表最后添加一个元素
     * @return
     */
    public boolean addLastElement(Object obj){
        // 实例化一个节点
        Node newNode = new Node(null, obj, null);

        // 头节点为null，直接将实例化的节点赋予head
        if(head == null) {
            head = newNode;
            return true;
        }

        // 若头节点部位null，查选到最末尾的节点，再添加实例化的节点
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        length++;
        return true;
    }

    /**
     * 添加一个元素,在某个位置
     *
     * 找到添加位置的前一个节点 index = 5
     * 0--> 1 --> 2 --> 3 --> 4 -->  5  --> 6 --> 7 --> 8 --> 9
     * 0--> 1 --> 2 --> 3 --> 4 --> 100 --> 5 --> 6 --> 7 --> 8 --> 9
     * @return
     */
    public boolean addElement(Object obj, int index){
        if(!cheackIndex(index)) {
            System.out.println("添加一个元素,在某个位置,输入的下标不合法");
            return false;
        }

        // 实例化一个节点
        Node newNode = new Node(null, obj, null);
        // int length = getLength();

        if(index == 0){ // 在链表头插入
            newNode.next = head;
            head = newNode;
        }else if(index == length - 1 ){
            Node indexNode = (Node) getByIndex(index);
            indexNode.next = newNode;
        }else{
            Node indexPrevNode = (Node) getByIndex(index - 1);
            Node indexNode = (Node) getByIndex(index);
            // 插入操作
            newNode.next = indexNode;
            indexPrevNode.next = newNode;
        }
        length++;
        return true;
    }

    /**
     * 删除链表最后一个元素
     * @return
     */
    public boolean removeLastElement(){

        // int length = getLength();

        if(length == 1){
            head = null;
            length--;
        }else if(length > 1){
            // 最后一个元素的前一个元素
            Node lastElePrev = (Node) getByIndex(length - 2);
            lastElePrev.next = null;
            length--;
        }
        return true;
    }

    /**
     * 删除指定位置的元素
     * @return
     */
    public boolean removeElement(int index){
        if(!cheackIndex(index)) {
            System.out.println("删除一个元素,在某个位置,输入的下标不合法");
            return false;
        }

        // int length = getLength();

        if(index == length - 1){ // 删除指定的元素为链表的最后一个元素
            Node lastElePrev = (Node) getByIndex(index - 1);
            lastElePrev.next = null;

        }else if(index == 0){ // 删除指定的元素为链表的第一个元素
            Node indexNextEle = (Node) getByIndex(index + 1);
            head = indexNextEle;

        }else{ // 删除的是中间的元素
            Node indexPrevEle = (Node) getByIndex(index - 1);
            Node indexNextEle = (Node) getByIndex(index + 1);
            indexPrevEle.next = indexNextEle;
        }
        length--;
        return true;
    }

    /**
     * 查看链表信息
     */
    public void showInfo(){
        System.out.println("链表的长度为："+ length);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.element + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

}