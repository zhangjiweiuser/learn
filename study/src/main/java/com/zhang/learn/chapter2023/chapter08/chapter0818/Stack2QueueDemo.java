package com.zhang.learn.chapter2023.chapter08.chapter0818;

import java.util.Stack;

public class Stack2QueueDemo {
    public static void main(String[] args) {
        Stack2Queue queue = new Stack2Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
    }
}
class Stack2Queue{
//push to top, peek/pop from top, size, 和 is empty
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(Integer val){
        stack1.push(val);
    }
    public Integer pop(){
        if(isEmpty()){
            return null;
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
    public Integer peek(){
        if(isEmpty()){
            return null;
        }
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
    public Integer size(){
        return stack1.size() +stack2.size();
    }

    public boolean isEmpty(){
        return stack2.isEmpty() && stack1.isEmpty();
    }

}
