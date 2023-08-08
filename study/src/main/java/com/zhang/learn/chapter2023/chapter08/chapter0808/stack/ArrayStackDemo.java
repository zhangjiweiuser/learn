package com.zhang.learn.chapter2023.chapter08.chapter0808.stack;

/**
 * @author zhangjiwei1
 * @description
 * @create 2023-08-08 14:24
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        System.out.println("是否为空:"+stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("--------");
        System.out.println(stack.pop());
        System.out.println("-------");
        stack.list();
    }
}

// 定义一个ArrayStack 表示栈
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，用数组来模拟栈，数据放在这里
    private int top = -1; // top表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了，该数据被丢弃，"+value);
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        return stack[top--];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据。。。");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("栈stack[%d]=%d\n", i, stack[i]);
        }
    }
}
