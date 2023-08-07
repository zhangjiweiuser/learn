package com.zhang.learn.chapter2023.chapter08.chapter0807;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-07 17:35
 */
public class Josepfu {
    public static void main(String[] args) {

    }
}

// 创建一个环形的单向链表
class CircleSingleLinkedList{

}

class BodyNode{
    private int id;
    private BodyNode next;

    public BodyNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BodyNode getNext() {
        return next;
    }

    public void setNext(BodyNode next) {
        this.next = next;
    }
}
