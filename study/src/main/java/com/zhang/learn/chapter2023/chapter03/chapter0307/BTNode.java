package com.zhang.learn.chapter2023.chapter03.chapter0307;

public class BTNode<E> {
    E data;
    BTNode<E> lchild;
    BTNode<E> rchild;

    public BTNode() {
        lchild = rchild = null;
    }

    public BTNode(E data) {
        this.data = data;
        lchild = rchild = null;
    }
}
