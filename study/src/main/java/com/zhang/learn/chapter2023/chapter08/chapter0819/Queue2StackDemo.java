package com.zhang.learn.chapter2023.chapter08.chapter0819;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class Queue2StackDemo {
    public static void main(String[] args) {
        Queue2Stack stack = new Queue2Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("pop:" + stack.pop());
        stack.push(4);
        System.out.println("top:" + stack.top());
        System.out.println("pop:" + stack.pop());

    }
}

class Queue2Stack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public Queue2Stack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(Integer val) {
        if (empty()) {
            queue1.add(val);
        } else if (queue1.isEmpty()) {
            queue2.add(val);
        } else {
            queue1.add(val);
        }
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty() && queue2.size() > 1) {
                Integer poll = queue2.poll();
                queue1.add(poll);
            }
            return queue2.poll();
        } else {
            while (!queue1.isEmpty() && queue1.size() > 1) {
                Integer poll = queue1.poll();
                queue2.add(poll);
            }
            return queue1.poll();
        }
    }

    public Integer top() {
        Integer result;
        if (empty()) {
            return null;
        }
        if (queue1.isEmpty()) {
            while (!queue2.isEmpty() && queue2.size() > 1) {
                Integer poll = queue2.poll();
                queue1.add(poll);
            }
            result = queue2.poll();
            queue1.add(result);
            return result;
        } else {
            while (!queue1.isEmpty() && queue1.size() > 1) {
                Integer poll = queue1.poll();
                queue2.add(poll);
            }
            result = queue1.poll();
            queue2.add(result);
            return result;
        }
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
