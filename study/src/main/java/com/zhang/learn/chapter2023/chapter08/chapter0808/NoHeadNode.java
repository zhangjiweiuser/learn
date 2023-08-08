package com.zhang.learn.chapter2023.chapter08.chapter0808;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-08 9:58
 */
public class NoHeadNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        Node node = oddEvenList(n1);
        while(node != null){
            System.out.println(node.id);
            node = node.next;
        }
//        System.out.println(isPail(n1));
//        show(n1);
//        System.out.println("----------");
//        Node rev = reverse(n1);
//        show(rev);
    }

    public static Node reverse(Node head){
        Node cur = null,pre = null;
        while(head != null){
            cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return cur;
    }
    public static void show(Node node){
        while(node != null){
            System.out.println(node.id);
            node = node.next;
        }
    }

    public static boolean isPail (Node head) {
        // write code here
        Node cur = null,pre = null;
        Node t = head;
        Node tmp = head;
        while(t != null){
            cur = t;
            t = t.next;
            cur.next = pre;
            pre = cur;
        }

        while(cur != null){
            if(cur.id == tmp.id){
                cur = cur.next;
                tmp = tmp.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public static Node oddEvenList (Node head) {
        // write code here

        Node ji = null;
        Node ou = null;

        Node re = new Node(-1);
        if(head != null){
            ji = head;
            re.next = ji;
            head = head.next;
        }
        if(head != null){
            ou = head;
            ji.next = ou;
            head = head.next;
        }
        Node cur = head;
        int no = 3;
        while(cur != null){
            Node t = cur;
            cur = cur.next;
            if(no % 2 == 1){
                t.next = ji.next;
                ji.next = t;
                ji = ji.next;
                no++;
            }else{
                t.next = ou.next;
                ou.next = t;
                ou = ou.next;
                no++;
            }
        }
        ou.next = null;
        return re.next;
    }
}
class Node{
    public int id;
    public Node next;

    public Node(int id) {
        this.id = id;
    }
}
