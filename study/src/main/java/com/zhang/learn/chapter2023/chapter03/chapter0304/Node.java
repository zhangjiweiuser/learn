package com.zhang.learn.chapter2023.chapter03.chapter0304;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public boolean add(E item) {
        Node<E> tNode = new Node<>(item, null);
        Node<E> p = this;
        while(p.next != null){
            p = p.next;
        }
        p.next = tNode;
        return true;
    }

    public void print() {
        Node<E> t = this.next;
        while (t != null) {
            System.out.println(t.item);
            t = t.next;
        }
    }

    public Node<E> reverse(){
        Node<E> pNode = new Node<>(null, null);
        Node<E> tNode = pNode;
        Node<E> t = this.next;
        while(t!= null){
            Node<E> m = t;
            t = t.next;
            m.next = tNode.next;
            tNode.next = m;

        }
        return pNode.next;
    }
}
