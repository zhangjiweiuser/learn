package com.zhang.learn.chapter2023.chapter03.chapter0304;

import java.util.HashSet;
import java.util.Set;

public class MyLinkedListTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add("a");
//        set.add("b");
//        set.add("c");
//        set.add("d");
//        MyLinkedList<String> list = new MyLinkedList<>(set);
////        System.out.println(list.size());
//        list.remove("e");
//        System.out.println(list.toString());
//        reverse();
        split();
    }

    public static void reverse(){

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());
        Node<Integer> pNode = list.head.next;
        Node<Integer> qNode;
        list.head.next = null;
        while(pNode != null){
            qNode = pNode;
            pNode = pNode.next;
            qNode.next = list.head.next;
            list.head.next = qNode;
        }
        System.out.println(list.toString());
    }

    /**
     * 有一个2n长度的链表，{a0,b0,a1,b1...}
     * 转化为{a0,a1},{b0,b1}
     */
    public static void split(){

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        MyLinkedList<Integer> listA = new MyLinkedList<>();
        MyLinkedList<Integer> listB = new MyLinkedList<>();
        Node p = list.head.next;
        Node q;
        Node a1 = listA.head;
        Node b1 = listB.head;
        boolean insertA = true;

        while(p != null){
            q = p;
            p = p.next;
            q.next = null;
            if(insertA){
                a1.next = q;
                a1 = a1.next;
                insertA = false;
            }else{
                b1.next = q;
                b1 = b1.next;
                insertA = true;
            }
        }

        System.out.println(listA.toString());
        System.out.println(listB.toString());

    }
}
