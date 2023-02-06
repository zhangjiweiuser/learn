package com.zhang.learn.chapter2021.chapter03.chapter0329;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/3/29 9:44
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        for(int i=0;i<k;i++){
            ListNode node ;
            ListNode pre;
            while (null != head.next){

                pre = head;
                node = head.next;

            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        while (null != node1.next){
            System.out.println(node1.next.val);
            node1 = node1.next;
        }
    }
}
