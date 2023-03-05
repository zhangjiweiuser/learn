package com.zhang.learn.chapter2023.chapter03.chapter0305;

public class MyStack<E> {
    int initcapacity = 10;
    int capacity;
    Object[] data;
    private int top;

    public MyStack() {
        data = new Object[initcapacity];
        capacity = initcapacity;
        top = -1;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity <= capacity) {
            return;
        }
        Object[] result = new Object[minCapacity];
        for (int i = 0; i < top; i++) {
            result[i] = data[i];
        }
        data = result;
        capacity = minCapacity;
    }

    public boolean empty() {
        return top == -1;
    }

    public E peek() {
        if (top == -1) {
            return null;
        }
        return (E) data[top];
    }

    public E pop() {
        if (top == -1) {
            return null;
        }
        return (E) data[top--];
    }

    public boolean push(E item) {
        if (top == capacity - 1) {
            ensureCapacity(capacity << 1);
        }
        capacity = capacity << 1;
        data[++top] = item;
        return true;
    }
}
