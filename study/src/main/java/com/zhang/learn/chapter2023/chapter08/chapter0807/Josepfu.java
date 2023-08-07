package com.zhang.learn.chapter2023.chapter08.chapter0807;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-07 17:35
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.show();
        list.countBoy(1, 2, 5);
    }
}

// 创建一个环形的单向链表
class CircleSingleLinkedList {
    private BoyNode first = null;

    public void addBoy(int num) {
        if (num < 2) {
            System.out.println("小孩个数过少");
            return;
        }
        BoyNode curBoy = null;
        for (int i = 1; i <= num; i++) {
            BoyNode boy = new BoyNode(i);
            // 如果是第一个节点，他要指向他自己
            if (i == 1) {
                first = boy;
                first.next = first;
                curBoy = first;
            } else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }
        }
    }

    public void show() {
        BoyNode cur = first;
        do {
            System.out.println("当前小孩是:" + cur.id);
            cur = cur.next;
        } while (cur != first);
    }

    /**
     * @param startNo 从编号多少开始遍历
     * @param countNo 遍历几次
     * @param nums    总共多少个小孩
     */
    public void countBoy(int startNo, int countNo, int nums) {
        // 先将helper指向first的最后一个小孩
        BoyNode helper = first;
        do {
            helper = helper.next;
        } while (helper.next != first);
        // 将要遍历的第一个节点，指向startNo编号
        for (int i = 0; i < startNo - 1; i++) {
            first = first.next;
            helper = helper.next;
        }
        while (helper != first) {
            // 开始遍历，只需要遍历countNo-1次
            for (int i = 0; i < countNo - 1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println("当前出圈小孩是" + first.id);
            //  将first节点后移，然后将helper的下一个节点指向first
            first = first.next;
            helper.next = first;
        }
        System.out.println("最后留下来的小孩是" + helper.id);
    }
}

class BoyNode {
    public int id;
    public BoyNode next;

    public BoyNode(int id) {
        this.id = id;
    }
}
