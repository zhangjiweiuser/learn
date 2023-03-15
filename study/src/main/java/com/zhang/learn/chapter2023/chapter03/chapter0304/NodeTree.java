package com.zhang.learn.chapter2023.chapter03.chapter0304;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-03-09 11:13
 */
public class NodeTree {
    public static void main(String[] args) {
        Node<String> head = new Node<>(null,null);
        head.add("a");
        head.add("b");
        head.add("c");
        head.add("d");
        head.add("e");
        head.print();
        System.out.println("------------------");
        Node<String> reverse = head.reverse();
        while(reverse != null){
            System.out.println(reverse.item);
            reverse = reverse.next;
        }
    }
}
