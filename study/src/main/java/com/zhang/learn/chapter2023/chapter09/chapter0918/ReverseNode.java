package com.zhang.learn.chapter2023.chapter09.chapter0918;

public class ReverseNode {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        Node node5 = new Node(9);
        Node node6 = new Node(8);
        node5.next = node6;
        Node result = add(node1,node5);
//        Node reverse = reverse(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static Node add(Node h1, Node h2) {
        int carry = 0;
        Node ans = null;
        Node cur = null;
        for (int sum, val; h1 != null || h2 != null;
             h1 = h1 == null ? null : h1.next,
                     h2 = h2 == null ? null : h2.next) {
            sum = (h1 == null ? 0 : h1.val) + (h2 == null ? 0 : h2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            if(ans == null){
                ans = new Node(val);
                cur = ans;
            }else{
                cur.next = new Node(val);
                cur = cur.next;
            }
        }
        if(carry == 1){
            cur.next = new Node(1);
        }
        return ans;
    }

    private static Node reverse(Node head) {
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
