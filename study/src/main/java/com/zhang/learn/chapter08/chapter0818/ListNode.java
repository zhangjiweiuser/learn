package com.zhang.learn.chapter08.chapter0818;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/18 11:11
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode add(int val) {
        ListNode node = new ListNode(val);
        ListNode last = this;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        return this;
    }

}
