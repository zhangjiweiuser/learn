package com.zhang.learn.chapter2023.chapter03.chapter0304;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> {
    Node<E> head;

    public MyLinkedList() {
        head = new Node<E>(null, null);
    }

    public MyLinkedList(Collection<? extends E> c) {
        this();
        Node<E> p = head;
        for (E e : c) {
            Node<E> next = new Node<>(e, null);
            p.next = next;
            p = p.next;
        }
    }
    public boolean add(E e){
        Node<E> p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = new Node<>(e,null);
        return true;
    }
    public boolean remove(E e){
        Node<E> p = head;
        while(p.next != null && !p.next.item.equals(e)){
            p = p.next;
        }
        if(p.next == null && p.item.equals(e)){
            p.next = p.next.next;
            return true;
        }else if (!p.item.equals(e)){
            return false;
        }else {
            p.next = p.next.next;
            return true;
        }
    }
    public int size() {
        int count = 0;
        Node<E> phead = head;
        while (phead.next != null) {
            count++;
            phead = phead.next;
        }
        return count;
    }

    public String toString() {
        String str = "[";
        Node<E> p = head;
        if (p.next != null) {
            while (p.next.next != null) {
                p = p.next;
                str = str + p.item + ",";
            }
            str = str + p.next.item + "]";
        } else {
            str += "]";
        }
        return str;
    }
}
