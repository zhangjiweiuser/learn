package com.zhang.learn.chapter2023.chapter03.chapter0304;

import lombok.Data;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }
}
