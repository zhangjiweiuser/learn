package com.zhang.learn;

import java.util.Stack;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2020/9/21 11:39
 */
public class StackToQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public static void main(String[] args) {
        StackToQueue s2t = new StackToQueue();
        s2t.push(1);
        s2t.push(2);
        s2t.push(3);
        System.out.println("pop:" + s2t.pop());
        s2t.push(4);
        s2t.push(5);
        System.out.println("pop:" + s2t.pop());
        s2t.push(6);
        System.out.println("pop:" + s2t.pop());
        System.out.println("pop:" + s2t.pop());
        System.out.println("pop:" + s2t.pop());
        System.out.println("pop:" + s2t.pop());
    }

    private Integer push(int num) {
        return in.push(num);
    }

    private Integer peek() {
        if (!out.empty()) {
            return out.peek();
        }
        if (in.empty()) {
            return null;
        }
        while (!in.empty()) {
            out.push(in.pop());
        }
        return out.peek();
    }

    private Integer pop() {
        if (!out.empty()) {
            return out.pop();
        }
        if (in.empty()) {
            return null;
        }
        while (!in.empty()) {
            out.push(in.pop());
        }
        return out.pop();
    }
}
